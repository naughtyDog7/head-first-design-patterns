package org.example.ch06_command;

import lombok.extern.slf4j.Slf4j;
import org.example.ch06_command.commands.light.LightOffCommand;
import org.example.ch06_command.commands.light.LightOnCommand;
import org.example.ch06_command.remote.SimpleRemoteControl;
import org.example.ch06_command.vendor.Light;

@Slf4j
public class Main {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light("guest room");

        remoteControl.setCommand(new LightOnCommand(light));
        remoteControl.click();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.click();

        remoteControl.setCommand(new LightOffCommand(light));
        remoteControl.click();

        remoteControl.undo();
        remoteControl.undo();
        remoteControl.undo();
    }
}
