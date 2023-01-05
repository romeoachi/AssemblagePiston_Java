package ary.assemblagepiston.demo.domain.abstracts;

import ary.assemblagepiston.demo.domain.InfoProcessPieceView;
import ary.assemblagepiston.demo.domain.Piece;

public abstract class PistonMachineAbstract extends MachineAbstract {

    protected Piece piece;

    protected PistonMachineAbstract(Double durationProcess, Piece piece) {
        super(durationProcess);
        this.piece = piece;
    }

    public InfoProcessPieceView getInfoProcessCurrentPiece() {
        return InfoProcessPieceView.set(this.durationProcess, piece);
    }
}
