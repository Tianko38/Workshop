package com.workshop.observing;

public interface Observable {

    void subscribe(Observer observer);
    void unsubscribe(Observer observer);

    void notifyObservers();
    Observable getUpdate();
}