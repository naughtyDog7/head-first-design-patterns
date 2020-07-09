package org.example.ch12_compound.mvc.heart;

import org.example.ch12_compound.mvc.view.BeatObserver;
import org.example.ch12_compound.mvc.view.BpmObserver;

public interface HeartModelInterface {
    int getHeartRate();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BpmObserver o);
    void removeObserver(BpmObserver o);
}
