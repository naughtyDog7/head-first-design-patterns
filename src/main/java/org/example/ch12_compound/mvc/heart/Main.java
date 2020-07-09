package org.example.ch12_compound.mvc.heart;

import org.example.ch12_compound.mvc.controller.ControllerInterface;

public class Main {
    public static void main(String[] args) {
        HeartModel heart = new HeartModel();
        ControllerInterface controller = new HeartController(heart);
        heart.start();
    }
}
