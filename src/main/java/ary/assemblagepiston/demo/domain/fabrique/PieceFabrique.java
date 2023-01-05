package ary.assemblagepiston.demo.domain.fabrique;

import ary.assemblagepiston.demo.domain.InfoProcessPieceView;
import ary.assemblagepiston.demo.domain.Piece;
import ary.assemblagepiston.demo.domain.marchinepiston.PistonMachineMA;
import ary.assemblagepiston.demo.domain.marchinepiston.PistonMachineMJ;
import ary.assemblagepiston.demo.domain.marchinepiston.PistonMachineMT;

public class PieceFabrique {

    private PieceFabrique() {
    }

     public static  InfoProcessPieceView make(Piece piece){
        return switch (piece.getTypePiece()) {
            case MA -> PistonMachineMA.setPiece(piece).getInfoProcessCurrentPiece();
            case MT -> PistonMachineMT.setPiece(piece).getInfoProcessCurrentPiece();
            case MJ -> PistonMachineMJ.setPiece(piece).getInfoProcessCurrentPiece();
        };
    }
}
