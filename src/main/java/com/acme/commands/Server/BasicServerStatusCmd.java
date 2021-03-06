package com.acme.commands.Server;

import com.acme.beans.ServerStatus;
import com.acme.commands.Command;

/**
 * Command for determining the basic server status
 */
public class BasicServerStatusCmd implements Command {

    private final long Id;
    private final String template;
    private final String name;

    private ServerStatus status;

    public BasicServerStatusCmd(long Id, String template, String name) {
        this.Id = Id;
        this.template = template;
        this.name = name;
    }

    @Override
    public void execute() {
        status = new ServerStatus(Id, String.format(template, name));
        status.setStatusDesc(status.createStatusDesc());
    }

    @Override
    public ServerStatus getResult() {
        return status;
    }
}
