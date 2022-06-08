package com.workshop.commands;

import com.workshop.Santa;
import com.workshop.factoryMethod.Workshop;
import com.workshop.toys.Bicycle;
import com.workshop.toys.Toy;

import java.util.Optional;

public class NeedBicyclesCommand implements NeedToyCommand {
    @Override
    public void execute() {
        Workshop workshop = Workshop.getINSTANCE();
        Optional<Toy> toy = workshop.getCreatedToys().stream().filter(toy1 -> toy1 instanceof Bicycle).findFirst();
        if (toy.isEmpty()){
            System.out.println("Out of bicycles");
        }else {
            Bicycle bicycle = (Bicycle) toy.get();
            workshop.getCreatedToys().remove(bicycle);
            Santa.getINSTANCE().addBicycle(bicycle);
        }

    }
}
