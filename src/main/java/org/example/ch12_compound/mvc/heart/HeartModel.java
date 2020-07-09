package org.example.ch12_compound.mvc.heart;

import org.example.ch12_compound.mvc.view.BeatObserver;
import org.example.ch12_compound.mvc.view.BpmObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Thread.currentThread;

public class HeartModel implements HeartModelInterface, Runnable {
    private int time = 1000;
    private final Random rand = new Random();
    private final List<BeatObserver> beatObservers = new ArrayList<>();
    private final List<BpmObserver> bpmObservers = new ArrayList<>();
    private final Thread thread;

    public HeartModel() {
        thread = new Thread(this);
    }

    public void start() {
        thread.start();
    }

    @Override
    public void run() {
        int lastRate = -1;
        while (!currentThread().isInterrupted()) {
            int change = rand.nextInt(20) - 10;
            int rate = 60000/(time + change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastRate) {
                    lastRate = rate;
                    notifyBpmObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                currentThread().interrupt();
            }
        }
    }

    private void notifyBeatObservers() {
        beatObservers.forEach(BeatObserver::updateBeat);
    }

    private void notifyBpmObservers() {
        bpmObservers.forEach(BpmObserver::updateBpm);
    }

    @Override
    public int getHeartRate() {
        return 60000/time;
    }

    @Override
    public void registerObserver(BeatObserver o) {
        beatObservers.add(o);
    }

    @Override
    public void removeObserver(BeatObserver o) {
        beatObservers.remove(o);
    }

    @Override
    public void registerObserver(BpmObserver o) {
        bpmObservers.add(o);
    }

    @Override
    public void removeObserver(BpmObserver o) {
        bpmObservers.remove(o);

    }
}
