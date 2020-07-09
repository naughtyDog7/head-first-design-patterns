package org.example.ch12_compound.mvc.heart;

import org.example.ch12_compound.mvc.controller.ControllerInterface;
import org.example.ch12_compound.mvc.view.DJView;

public class HeartController implements ControllerInterface {
    private final HeartModelInterface heart;
    private final DJView djView;

    public HeartController(HeartModelInterface heart) {
        this.heart = heart;
        djView = new DJView(new HeartAdapter(heart), this);
        djView.createView();
        djView.createControls();
        djView.disableStartMenuItem();
        djView.disableStopMenuItem();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBpm() {

    }

    @Override
    public void decreaseBpm() {

    }

    @Override
    public void setBpm(int bpm) {

    }
}
