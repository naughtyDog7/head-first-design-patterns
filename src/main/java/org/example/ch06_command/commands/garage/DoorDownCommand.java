package org.example.ch06_command.commands.garage;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.vendor.GarageDoor;

import java.util.concurrent.atomic.AtomicBoolean;

public class DoorDownCommand implements Command {
    private final GarageDoor garageDoor;
    private final AtomicBoolean changed = new AtomicBoolean(false);

    public DoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        if (garageDoor.getOpened().get())
            changed.set(true);
        garageDoor.down();
    }

    @Override
    public void undo() {
        if (changed.get()) {
            garageDoor.up();
        }
    }
}
