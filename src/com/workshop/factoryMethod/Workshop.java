package com.workshop.factoryMethod;

import com.workshop.toys.Bicycle;
import com.workshop.toys.Toy;

import java.util.ArrayList;
import java.util.List;

public class Workshop {
    private Workshop(){

    }
    private static Workshop instance ;

    public static Workshop getINSTANCE(){

        if(instance == null) {
            instance = new Workshop();
        }

        return instance;
    };

    private DollFactory dollFactory = new DollFactory();
    private BicycleFactory bicycleFactory = new BicycleFactory();
    private List<Toy> createdToys = new ArrayList<>();

    public DollFactory getDollFactory() {
        return dollFactory;
    }

    public void setDollFactory(DollFactory dollFactory) {
        this.dollFactory = dollFactory;
    }

    public BicycleFactory getBicycleFactory() {
        return bicycleFactory;
    }

    public void setBicycleFactory(BicycleFactory bicycleFactory) {
        this.bicycleFactory = bicycleFactory;
    }

    public List<Toy> getCreatedToys() {
        return createdToys;
    }

    public void setCreatedToys(List<Toy> createdToys) {
        this.createdToys = createdToys;
    }

    public void loadWithToys(){
        Toy bicycle1 = bicycleFactory.produceToy("Bicycle");
        Toy bicycle2 = bicycleFactory.produceToy("Bicycle");
        Toy bicycle3 = bicycleFactory.produceToy("Bicycle");
        Toy doll1 = dollFactory.produceToy("Doll");
        Toy doll2 = dollFactory.produceToy("Doll");
        Toy doll3 = dollFactory.produceToy("Doll");
        createdToys.add(bicycle1);
        createdToys.add(bicycle2);
        createdToys.add(bicycle3);
        createdToys.add(doll1);
        createdToys.add(doll2);
        createdToys.add(doll3);
    }
}
