package com.workshop.observing;

import com.workshop.commands.NeedBicyclesCommand;
import com.workshop.commands.NeedDollsCommand;
import com.workshop.commands.NeedToyCommand;
import javafx.scene.web.HTMLEditorSkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MagicBoard implements Observable {

    private List<Observer> observers = new ArrayList<>();
    private List<NeedToyCommand> needToyNeedToyCommands = new ArrayList<>();

    public List<NeedToyCommand> getNeedToyNeedToyCommands() {
        return needToyNeedToyCommands;
    }

    public void setNeedToyNeedToyCommands(List<NeedToyCommand> needToyNeedToyCommands) {
        this.needToyNeedToyCommands = needToyNeedToyCommands;
    }

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
        observer.setObservable(this);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
        observer.setObservable(null);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: this.observers) {
            observer.update();
        }
    }

    @Override
    public Observable getUpdate() {
        return this;
    }

    public void setNewCommand(String magicWords){
        NeedToyCommand command = parseMagicWords(magicWords);
        if (command == null){
            System.out.println("Сбърка магическите думи");
            return;
        }
        needToyNeedToyCommands.add(command);
        this.notifyObservers();
    }

    public void setNewCommands(List<String> manyMagicWords){
        List<NeedToyCommand> needToyCommandList = manyMagicWords.stream()
                .map(this::parseMagicWords).filter(Objects::nonNull)
                .collect(Collectors.toList());
        needToyNeedToyCommands.addAll(needToyCommandList);
        this.notifyObservers();
    }

    public NeedToyCommand parseMagicWords(String magicWords){
        switch (magicWords){
            case "Трябват ми кукли":
                return new NeedDollsCommand();
            case "Трябват ми колелета":
                return new NeedBicyclesCommand();
            default:
                return null;
        }
    }
}
