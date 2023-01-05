package ary.assemblagepiston.demo.domain.marchinepiston;


import ary.assemblagepiston.demo.domain.Piece;
import ary.assemblagepiston.demo.domain.abstracts.PistonMachineAbstract;

public class PistonMachineMA extends PistonMachineAbstract {

    private static final double DURATION_PROCESS = 2.5;

    public static PistonMachineMA setPiece(Piece piece){
        return new PistonMachineMA(DURATION_PROCESS, piece);
    }

    private PistonMachineMA(Double durationProcess, Piece piece) {
        super(durationProcess, piece);
    }
}
