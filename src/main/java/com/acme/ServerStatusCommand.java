package com.acme;

import com.acme.beans.ServerStatus;

public interface ServerStatusCommand {

    public ServerStatus determineStatus();
}
