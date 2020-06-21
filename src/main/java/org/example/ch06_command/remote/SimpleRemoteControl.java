package org.example.ch06_command.remote;

import org.example.ch06_command.commands.Command;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleRemoteControl {
    private final Queue<Command> commandQueue;

    public SimpleRemoteControl() {
        this.commandQueue = new ConcurrentLinkedQueue<>();
    }

    public void addCommand(Command command) {
        commandQueue.offer(command);
    }

    public void click() {
        if (commandQueue.isEmpty())
            throw new NullPointerException("No commands specified");
        commandQueue.poll().execute();
    }

    public void executeAll() {
        if (commandQueue.isEmpty())
            throw new NullPointerException("No commands specified");
        commandQueue.forEach(Command::execute);
        commandQueue.clear();
    }
}
