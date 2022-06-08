package com.workshop.factoryMethod;

import com.workshop.toys.Doll;
import com.workshop.toys.Toy;

public class DollFactory extends ToyFactory {
    @Override
    public Toy createToy(String toyName) {
        Doll doll = new Doll();
        doll.prepare();
        return doll;
    }
}
