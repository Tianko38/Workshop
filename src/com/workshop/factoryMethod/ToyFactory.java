package com.workshop.factoryMethod;

import com.workshop.toys.Toy;

public abstract class  ToyFactory {
    public abstract Toy createToy(String toyName);

    public Toy produceToy(String toyName) {
        Toy toy = createToy(toyName);
        toy.prepare();
        return toy;
    }
}
