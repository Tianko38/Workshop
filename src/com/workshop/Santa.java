package com.workshop;

import com.workshop.observing.MagicBoard;
import com.workshop.toys.Bicycle;
import com.workshop.toys.Doll;

import java.util.ArrayList;
import java.util.List;


public class Santa {
    private Santa(){

    }
    private static Santa instance ;

    public static Santa getINSTANCE(){
        
        if(instance == null) {
            instance = new Santa();
        }

        return instance;
    };

    private MagicBoard magicBoard = new MagicBoard();
    private List<Doll> dolls = new ArrayList<>();
    private List<Bicycle> bicycles = new ArrayList<>();

    public List<Doll> getDolls() {
        return dolls;
    }

    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    public MagicBoard getMagicBoard() {
        return magicBoard;
    }

    public void setMagicBoard(MagicBoard magicBoard) {
        this.magicBoard = magicBoard;
    }

    public void requestToy(String magicWords){
        magicBoard.setNewCommand(magicWords);
    }

    public void requestToys(List<String> manyMagicWords){
        if (manyMagicWords.size() > 3){
            System.out.println("Can't request that many toys at once");
            return;
        }

        magicBoard.setNewCommands(manyMagicWords);
    }

    public void addDoll(Doll doll){
        dolls.add(doll);
        System.out.println("Santa got a doll");
    }

    public void addBicycle(Bicycle bicycle){
        bicycles.add(bicycle);
        System.out.println("Santa got a bicycle");
    }

}
