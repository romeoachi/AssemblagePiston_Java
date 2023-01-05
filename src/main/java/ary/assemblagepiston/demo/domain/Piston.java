package ary.assemblagepiston.demo.domain;

public class Piston {
    private final PistonMT itemMT;
    private final PistonMJ itemMJ;
    private final PistonMA itemMA;
    private double durationProcess = 0;
    public Piston(InfoProcessPieceView currentPistonMTDisposable, InfoProcessPieceView currentPistonMJDisposable, InfoProcessPieceView currentPistonMADisposable, Double totalDurationProcessItem) {

        this.itemMT = (PistonMT) currentPistonMTDisposable.getPiece();
        this.itemMJ = (PistonMJ) currentPistonMJDisposable.getPiece();
        this.itemMA = (PistonMA) currentPistonMADisposable.getPiece();
        this.durationProcess = totalDurationProcessItem;
    }

    @Override
    public String toString() {
        return "Piston{" +
                "itemMT=" + itemMT +
                ", itemMJ=" + itemMJ +
                ", itemMA=" + itemMA +
                ", durationProcess=" + durationProcess +
                '}';
    }

    public double getDurationProcess() {
        return durationProcess;
    }
}
