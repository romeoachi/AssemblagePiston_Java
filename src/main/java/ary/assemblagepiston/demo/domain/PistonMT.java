package ary.assemblagepiston.demo.domain;

import ary.assemblagepiston.demo.domain.enums.EnumTypePiece;

public class PistonMT implements Piece {
    @Override
    public EnumTypePiece getTypePiece() {
        return EnumTypePiece.MT;
    }
}
