package ary.assemblagepiston.demo.domain;

import ary.assemblagepiston.demo.domain.enums.EnumTypePiece;

public class PistonMJ implements Piece {
    @Override
    public EnumTypePiece getTypePiece() {
        return EnumTypePiece.MJ;
    }
}
