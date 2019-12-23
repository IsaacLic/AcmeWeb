package com.acme.executors;

import com.acme.commands.Command;

public interface IStatusCommandExecutor {

    public void executeCommand(Command command);

}