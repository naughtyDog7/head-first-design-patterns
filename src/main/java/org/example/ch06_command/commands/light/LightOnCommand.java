package org.example.ch06_command.commands.light;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.vendor.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
