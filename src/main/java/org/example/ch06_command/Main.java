package org.example.ch06_command;

import lombok.extern.slf4j.Slf4j;
import org.example.ch06_command.commands.garage.DoorDownCommand;
import org.example.ch06_command.remote.SimpleRemoteControl;
import org.example.ch06_command.vendor.GarageDoor;
import org.example.ch06_command.vendor.Light;

@Slf4j
public class Main {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        GarageDoor garageDoor = new GarageDoor(new Light("garage"));

        remoteControl.addCommand(new DoorDownCommand(garageDoor));
        remoteControl.addCommand(garageDoor::lightOn);
        log.info("start");
        remoteControl.executeAll();
    }
}
