package com.acme;

import com.acme.beans.StatusInfo;

public interface IStatusCommandExecutor {

    public void addServerStatusCommand(Command command);

    public StatusInfo runNextStatusCommand();
}