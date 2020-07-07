package org.example.ch12_compound.mvc.controller;

public interface ControllerInterface {
    void start();
    void stop();
    void increaseBpm();
    void decreaseBpm();
    void setBpm(int bpm);
}
