package org.example.ch06_command.commands.light;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.vendor.Light;

import java.util.concurrent.atomic.AtomicBoolean;

public class LightOffCommand implements Command {
    private final Light light;
    private final AtomicBoolean changed = new AtomicBoolean(false);


    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        if (light.getOn().get())
            changed.set(true);
        light.off();
    }

    @Override
    public void undo() {
        if (changed.get())
            light.on();
    }
}
