package ary.assemblagepiston.demo.domain.marchinepiston;

import ary.assemblagepiston.demo.domain.Piece;
import ary.assemblagepiston.demo.domain.abstracts.PistonMachineAbstract;

public class PistonMachineMJ extends PistonMachineAbstract {
    private static final double DURATION_PROCESS = 3;

    public static PistonMachineMJ setPiece(Piece piece){
        return new PistonMachineMJ(DURATION_PROCESS, piece);
    }

    private PistonMachineMJ(Double durationProcess, Piece piece) {
        super(durationProcess, piece);
    }
}
