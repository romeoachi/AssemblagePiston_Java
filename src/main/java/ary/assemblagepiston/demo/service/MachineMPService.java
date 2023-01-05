package ary.assemblagepiston.demo.service;

import ary.assemblagepiston.demo.domain.InfoProcessPieceView;
import ary.assemblagepiston.demo.domain.Piece;
import ary.assemblagepiston.demo.domain.Piston;
import ary.assemblagepiston.demo.domain.RandomUtils;
import ary.assemblagepiston.demo.domain.enums.EnumTypePiece;
import ary.assemblagepiston.demo.domain.fabrique.PieceFabrique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MachineMPService {

    private final List<InfoProcessPieceView> pistonMAS = new ArrayList<>();
    private final List<InfoProcessPieceView> pistonMJS = new ArrayList<>();
    private final List<InfoProcessPieceView> pistonMTS = new ArrayList<>();

    private final List<Piston> pistons = new ArrayList<>();

    private List<InfoProcessPieceView> infoProcessPieceViews;
    private static final double DURATION_PROCESS = 1;

    public static MachineMPService setPiecesPiston(List<Piece> pieces) {
        return new MachineMPService(pieces);
    }

    public double getTotalDurationProcess() {
        return pistons.stream().map(Piston::getDurationProcess)
                .mapToDouble(value -> value).sum();
    }

    private MachineMPService(List<Piece> pieces) {
        makePiecesProcess(pieces);
        filterAndMergePistonPieces();
    }

    private void makePiecesProcess(List<Piece> pieces) {
        infoProcessPieceViews = pieces.stream()
                .map(PieceFabrique::make).toList();
    }

    public void filterAndMergePistonPieces() {

        infoProcessPieceViews.forEach(infoProcessPiece -> {
            if (EnumTypePiece.MT.equals(infoProcessPiece.getPiece().getTypePiece()))
                pistonMTS.add(infoProcessPiece);
            if (EnumTypePiece.MJ.equals(infoProcessPiece.getPiece().getTypePiece()))
                pistonMJS.add(infoProcessPiece);
            if (EnumTypePiece.MA.equals(infoProcessPiece.getPiece().getTypePiece()))
                pistonMAS.add(infoProcessPiece);

            while (!pistonMTS.isEmpty() && !pistonMJS.isEmpty() && !pistonMAS.isEmpty()) {
                var currentPistonMTDisposable = pistonMTS.stream().findFirst().get();
                var currentPistonMJDisposable = pistonMJS.stream().findFirst().get();
                var currentPistonMADisposable = pistonMAS.stream().findFirst().get();
                var durationOfPiston = getMaxDurationCurrentProcessMergePistonItems(currentPistonMTDisposable, currentPistonMJDisposable, currentPistonMADisposable)
                        + getCurrentDurationMachineMPByProcess();

                pistons.add(assemblePiston(currentPistonMTDisposable, currentPistonMJDisposable, currentPistonMADisposable, durationOfPiston));
                removePiecesAlreadyAssembled(currentPistonMTDisposable, currentPistonMJDisposable, currentPistonMADisposable);
            }
        });
    }

    private static Double getMaxDurationCurrentProcessMergePistonItems(InfoProcessPieceView currentPistonMTDisposable, InfoProcessPieceView currentPistonMJDisposable, InfoProcessPieceView currentPistonMADisposable) {
        return Collections.max(
                List.of(
                        currentPistonMTDisposable.getDurationProcess(),
                        currentPistonMJDisposable.getDurationProcess(),
                        currentPistonMADisposable.getDurationProcess()
                )
        );
    }

    private void removePiecesAlreadyAssembled(InfoProcessPieceView currentPistonMTDisposable, InfoProcessPieceView currentPistonMJDisposable, InfoProcessPieceView currentPistonMADisposable) {
        pistonMTS.remove(currentPistonMTDisposable);
        pistonMJS.remove(currentPistonMJDisposable);
        pistonMAS.remove(currentPistonMADisposable);
    }

    private static Double getCurrentDurationMachineMPByProcess() {
        return RandomUtils.getExtraTimeDurationTrouble(RandomUtils.isMachineDown()) + DURATION_PROCESS;
    }

    private Piston assemblePiston(InfoProcessPieceView currentPistonMTDisposable, InfoProcessPieceView currentPistonMJDisposable, InfoProcessPieceView currentPistonMADisposable, Double totalDurationProcessItem) {
        return new Piston(currentPistonMTDisposable, currentPistonMJDisposable, currentPistonMADisposable, totalDurationProcessItem);
    }



}
