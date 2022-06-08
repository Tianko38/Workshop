package com.workshop.factoryMethod;

import com.workshop.toys.Bicycle;
import com.workshop.toys.Toy;

public class BicycleFactory extends ToyFactory {
    @Override
    public Toy createToy(String toyName) {
        Bicycle bicycle = new Bicycle();
        bicycle.prepare();
        return bicycle;
    }
}
