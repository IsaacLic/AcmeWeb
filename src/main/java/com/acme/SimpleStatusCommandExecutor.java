package com.acme;

import com.acme.beans.StatusInfo;
import org.springframework.context.annotation.Primary;

import java.util.LinkedList;
import java.util.Queue;

@Primary
public class SimpleStatusCommandExecutor implements IStatusCommandExecutor {

    private Queue<Command> commands = new LinkedList<Command>();

    @Override
    public void addServerStatusCommand(Command command) {
        commands.add(command);
    }

    @Override
    public StatusInfo runNextStatusCommand() {
        return commands.poll().determineStatus();
    }
}
