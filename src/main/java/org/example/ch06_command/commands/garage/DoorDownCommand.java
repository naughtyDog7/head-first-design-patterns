package org.example.ch06_command.commands.garage;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.vendor.GarageDoor;

public class DoorDownCommand implements Command {
    private final GarageDoor garageDoor;

    public DoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }
}
