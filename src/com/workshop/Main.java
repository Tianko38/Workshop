package com.workshop;

import com.workshop.factoryMethod.Workshop;
import com.workshop.observing.Dwarf;
import com.workshop.observing.MagicBoard;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dwarf dwarf1 = new Dwarf("Dwarf 01");
        Dwarf dwarf2 = new Dwarf("Dwarf 02");
        Dwarf dwarf3 = new Dwarf("Dwarf 03");

        MagicBoard magicBoard = Santa.getINSTANCE().getMagicBoard();
        magicBoard.subscribe(dwarf1);
        magicBoard.subscribe(dwarf2);
        magicBoard.subscribe(dwarf3);

        Workshop.getINSTANCE().loadWithToys();
        List<String> manyMagicWords = new ArrayList<String>();
        manyMagicWords.add("Трябват ми колелета");
        manyMagicWords.add("Трябват ми кукли");
        manyMagicWords.add("Трябват ми колелета");


        Santa santa = Santa.getINSTANCE();
        santa.requestToys(manyMagicWords);
//        santa.sayMagicWords("Трябват ми колелета");
//        santa.sayMagicWords("Трябват ми кукли");

        int santaBicycles = santa.getBicycles().size();
        int santaDolls = santa.getDolls().size();
        System.out.println("Santa got a total of " + santaBicycles + " bicycles");
        System.out.println("Santa got a total of " + santaDolls + " dolls");
    }

}
