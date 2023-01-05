package ary.assemblagepiston.demo.domain;

public class InfoProcessPieceView {
    private final Double durationProcess;
    private final Piece piece;

    private InfoProcessPieceView(Double durationProcess, Piece piece) {

        this.durationProcess = durationProcess;
        this.piece = piece;
    }

    public static InfoProcessPieceView set(Double durationProcess, Piece piece){
        return new InfoProcessPieceView(durationProcess,piece);
    }

    public Double getDurationProcess() {
        return durationProcess;
    }

    public Piece getPiece() {
        return piece;
    }
}
