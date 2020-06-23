package org.example.ch06_command.remote;

import org.example.ch06_command.commands.Command;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SimpleRemoteControl {
    private final Deque<Command> commandQueue;
    private final Deque<Command> executedCommands;

    public SimpleRemoteControl() {
        this.commandQueue = new ConcurrentLinkedDeque<>();
        this.executedCommands = new ConcurrentLinkedDeque<>();
    }

    public void addCommand(Command command) {
        commandQueue.offer(command);
    }

    public void click() {
        if (commandQueue.isEmpty())
            throw new NullPointerException("No commands specified");
        Command command = commandQueue.poll();
        command.execute();
        executedCommands.push(command);
    }

    public void undo() {
        if (executedCommands.isEmpty())
            throw new NullPointerException("Nothing to undo");
        executedCommands.pop().undo();
    }
}
