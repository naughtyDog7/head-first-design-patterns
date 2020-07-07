package org.example.ch12_compound.mvc;

import org.example.ch12_compound.mvc.controller.BeatController;
import org.example.ch12_compound.mvc.controller.ControllerInterface;
import org.example.ch12_compound.mvc.model.BeatModel;
import org.example.ch12_compound.mvc.model.BeatModelInterface;

public class Main {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
