package org.example.ch12_compound.mvc.controller;

import org.example.ch12_compound.mvc.model.BeatModelInterface;
import org.example.ch12_compound.mvc.view.DJView;

public class BeatController implements ControllerInterface {
    BeatModelInterface model;
    DJView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        view = new DJView(model, this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
        model.init();
    }

    @Override
    public void start() {
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void increaseBpm() {
        model.setBpm(model.getBpm() + 1);
    }

    @Override
    public void decreaseBpm() {
        model.setBpm(model.getBpm() - 1);
    }

    @Override
    public void setBpm(int bpm) {
        model.setBpm(bpm);
    }
}
