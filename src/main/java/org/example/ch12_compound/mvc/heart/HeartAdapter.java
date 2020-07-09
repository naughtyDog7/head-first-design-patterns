package org.example.ch12_compound.mvc.heart;

import org.example.ch12_compound.mvc.model.BeatModelInterface;
import org.example.ch12_compound.mvc.view.BeatObserver;
import org.example.ch12_compound.mvc.view.BpmObserver;

public class HeartAdapter implements BeatModelInterface {
    private final HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    @Override
    public void init() {
    }

    @Override
    public void on() {
    }

    @Override
    public void off() {
    }

    @Override
    public void setBpm(int bpm) {
    }

    @Override
    public int getBpm() {
        return heart.getHeartRate();
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        heart.removeObserver(observer);
    }

    @Override
    public void registerObserver(BpmObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BpmObserver observer) {
        heart.removeObserver(observer);
    }
}
