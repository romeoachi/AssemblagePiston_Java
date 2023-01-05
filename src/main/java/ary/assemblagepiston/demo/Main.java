package ary.assemblagepiston.demo;

import ary.assemblagepiston.demo.domain.*;
import ary.assemblagepiston.demo.service.MachineMPService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int COUNT_OF_EACH_PIECES = 100;

    public static void main(String[] args) {

        List<Piece> pieces = new ArrayList<>();

        int count = 0;
        while(count < COUNT_OF_EACH_PIECES){
            pieces.addAll(List.of(
                    new PistonMA(),
                    new PistonMJ(),
                    new PistonMT()
            ));
            count++;
        }



        MachineMPService machineMpService =  MachineMPService.setPiecesPiston(pieces);
        System.out.println(machineMpService.getTotalDurationProcess());

    }


}