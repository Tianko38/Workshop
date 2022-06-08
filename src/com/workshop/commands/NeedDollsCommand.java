package com.workshop.commands;

import com.workshop.Santa;
import com.workshop.factoryMethod.Workshop;
import com.workshop.toys.Doll;
import com.workshop.toys.Toy;

import java.util.Optional;

public class NeedDollsCommand implements NeedToyCommand {
    @Override
    public void execute() {
        Workshop workshop = Workshop.getINSTANCE();
        Optional<Toy> toy = workshop.getCreatedToys().stream().filter(toy1 -> toy1 instanceof Doll).findFirst();
        if (toy.isEmpty()){
            System.out.println("Out of dolls");
        }else {
            Doll doll = (Doll) toy.get();
            workshop.getCreatedToys().remove(doll);
            Santa.getINSTANCE().addDoll(doll);
        }

    }
}
