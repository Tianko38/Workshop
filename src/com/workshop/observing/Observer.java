package com.workshop.observing;

import com.workshop.observing.Observable;

public interface Observer {
    void update();
    void setObservable(Observable observable);
}