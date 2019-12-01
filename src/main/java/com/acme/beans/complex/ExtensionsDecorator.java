package com.acme.beans.complex;

import com.acme.beans.ServerStatus;

/**
 * Adds the detail about the extensions to the ServerStatus
 */
public class ExtensionsDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public ExtensionsDecorator(ServerStatus serverStatus) {
        super(serverStatus);

        this.serverStatus = serverStatus;
    }

    /**
     * Adds the extensions information to the status description
     *
     * @return the detailed status description
     */
    public String getStatusDesc() {
        return serverStatus.getStatusDesc() + ", and is using these extensions - " + serverManager.getExtensions();
    }
}
