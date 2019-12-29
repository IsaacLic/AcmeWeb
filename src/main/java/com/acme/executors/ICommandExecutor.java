package com.acme.executors;

import com.acme.commands.Command;

public interface ICommandExecutor {

    public void executeCommand(Command command);

}