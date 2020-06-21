package org.example.ch06_command.commands.light;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.vendor.Light;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
