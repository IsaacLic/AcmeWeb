package com.acme.beans.decorators.complex;


import com.acme.beans.ServerStatus;

/**
 * Abstract decorator for adding to the status description
 */
public abstract class ServerStatusDecorator extends ServerStatus {

    private final ServerStatus serverStatus;

    public ServerStatusDecorator(ServerStatus serverStatus) {
        super(serverStatus.getId(), serverStatus.getContentHeader());
        this.serverStatus = serverStatus;
    }

    /**
     * gets the basic server status
     *
     * @return String the current basic server status
     */
    public String getStatusDesc() {
        return serverManager.getCurrentServerStatus();
    }


    public long getId() {
        return serverStatus.getId();
    }

    public String getContentHeader() {

        return serverStatus.getContentHeader();
    }

}
