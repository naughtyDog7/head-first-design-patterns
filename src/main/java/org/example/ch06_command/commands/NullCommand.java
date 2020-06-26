package org.example.ch06_command.commands;

public class NullCommand implements Command {
    @Override
    public void execute() {
    }

    @Override
    public void undo() {
    }
}
