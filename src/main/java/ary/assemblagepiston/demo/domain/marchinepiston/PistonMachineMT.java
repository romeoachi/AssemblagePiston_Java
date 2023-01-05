package ary.assemblagepiston.demo.domain.marchinepiston;

import ary.assemblagepiston.demo.domain.Piece;
import ary.assemblagepiston.demo.domain.abstracts.PistonMachineAbstract;

public class PistonMachineMT extends PistonMachineAbstract {

    private static final double DURATION_PROCESS = 2;

    public static PistonMachineMT setPiece(Piece piece){
        return new PistonMachineMT(DURATION_PROCESS, piece);
    }

    private PistonMachineMT(Double durationProcess, Piece piece) {
        super(durationProcess, piece);
    }
}
