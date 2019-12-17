package com.acme.beans.complex;

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
    public String createStatusDesc() {
        return serverStatus.createStatusDesc() + ", and its " + serverManager.getMemoryStatus();
    }
}
