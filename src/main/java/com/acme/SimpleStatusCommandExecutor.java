package com.acme;

import com.acme.beans.ServerStatus;
import org.springframework.context.annotation.Primary;

import java.util.LinkedList;
import java.util.Queue;

@Primary
public class SimpleStatusCommandExecutor implements IStatusCommandExecutor {

    private Queue<ServerStatusCommand> commands = new LinkedList<ServerStatusCommand>();

    @Override
    public void addServerStatusCommand(ServerStatusCommand command) {
        commands.add(command);
    }

    @Override
    public ServerStatus runNextStatusCommand() {
        return commands.poll().determineStatus();
    }
}
