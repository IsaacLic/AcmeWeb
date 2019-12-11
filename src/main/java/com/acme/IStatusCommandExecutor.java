package com.acme;

import com.acme.beans.ServerStatus;

public interface IStatusCommandExecutor {

    public void addServerStatusCommand(ServerStatusCommand command);

    public ServerStatus runNextStatusCommand();
}