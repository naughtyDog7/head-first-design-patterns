package org.example.ch12_compound.mvc.model;

import org.example.ch12_compound.mvc.view.BpmObserver;
import org.example.ch12_compound.mvc.view.BeatObserver;

public interface BeatModelInterface {
    void init();

    void on();

    void off();

    void setBpm(int bpm);

    int getBpm();

    void registerObserver(BeatObserver observer);

    void removeObserver(BeatObserver observer);

    void registerObserver(BpmObserver observer);

    void removeObserver(BpmObserver observer);
}
