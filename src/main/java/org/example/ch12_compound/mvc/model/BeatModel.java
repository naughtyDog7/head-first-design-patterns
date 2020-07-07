package org.example.ch12_compound.mvc.model;

import lombok.Getter;
import org.example.ch12_compound.mvc.view.BpmObserver;
import org.example.ch12_compound.mvc.view.BeatObserver;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, MetaEventListener {
    private Sequencer sequencer;
    private final List<BeatObserver> beatObservers = new ArrayList<>();
    private final List<BpmObserver> bpmObservers = new ArrayList<>();
    @Getter
    private int bpm = 90;
    private Sequence sequence;
    private Track track;

    @Override
    public void init() {
        setUpMidi();
        buildTrackAndStart();
    }

    @Override
    public void on() {
        System.out.println("Starting sequencer");
        sequencer.start();
        setBpm(90);
    }

    @Override
    public void off() {
        setBpm(0);
        sequencer.stop();
    }

    @Override
    public void setBpm(int bpm) {
        this.bpm = bpm;
        sequencer.setTempoInBPM(bpm);
        notifyBpmObservers();
    }

    private void notifyBpmObservers() {
        bpmObservers.forEach(BpmObserver::updateBpm);
    }

    public void beatEvent() {
        notifyBeatObservers();
    }

    private void notifyBeatObservers() {
        beatObservers.forEach(BeatObserver::updateBeat);
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    @Override
    public void registerObserver(BpmObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BpmObserver observer) {
        bpmObservers.remove(observer);
    }

    @Override
    public void meta(MetaMessage meta) {
        if (meta.getType() == 47) {
            beatEvent();
            sequencer.start();
            setBpm(getBpm());
        }
    }

    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBpm());
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void buildTrackAndStart() {
        List<Integer> trackList = List.of(35, 0, 46, 0);

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try {
            sequencer.setSequence(sequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void makeTracks(List<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            if (key != 0) {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i + 1));
            }

        }

    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }


}
