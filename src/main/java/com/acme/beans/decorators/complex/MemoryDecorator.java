package com.acme.beans.decorators.complex;

import com.acme.beans.ServerStatus;

/**
 * Adds the detail about the memory to the ServerStatus
 */
public class MemoryDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public MemoryDecorator(ServerStatus serverStatus) {
        super(serverStatus);

        this.serverStatus = serverStatus;
    }

    /**
     * Adds the memory information to the status description
     *
     * @return the detailed status description
     */
    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + ", and its " + serverManager.getMemoryStatus();
    }
}
