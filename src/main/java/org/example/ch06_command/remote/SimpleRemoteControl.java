package org.example.ch06_command.remote;

import org.example.ch06_command.commands.Command;
import org.example.ch06_command.commands.NullCommand;

import java.util.Deque;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicReference;

public class SimpleRemoteControl {
    private final AtomicReference<Command> command;

    private final Deque<Command> executedCommands;

    public SimpleRemoteControl() {
        this.command = new AtomicReference<>(new NullCommand());
        this.executedCommands = new ConcurrentLinkedDeque<>();
    }

    public void setCommand(Command command) {
        this.command.set(Optional.ofNullable(command)
                .orElseGet(NullCommand::new));
    }

    public void click() {
        command.get().execute();
        executedCommands.push(command.get());
    }

    public void undo() {
        synchronized (executedCommands) {
            if (executedCommands.isEmpty())
                throw new NullPointerException("Nothing to undo");
            executedCommands.pop().undo();
        }
    }
}
