package com.workshop.observing;

import com.workshop.commands.NeedToyCommand;

import java.util.Random;

public class Dwarf implements Observer {
    private String name;
    private Observable observable;
    private Random rand = new Random();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dwarf(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        if(this.observable == null) {
            System.out.println("No observable set");
            return;
        }
        MagicBoard magicBoard = (MagicBoard) this.observable.getUpdate();
        if (magicBoard.getNeedToyNeedToyCommands().size() == 0) {
            return;
        }
        int int_rand = rand.nextInt(magicBoard.getNeedToyNeedToyCommands().size());
        NeedToyCommand needToyCommand = magicBoard.getNeedToyNeedToyCommands().remove(int_rand);
        needToyCommand.execute();
    }

    @Override
    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
