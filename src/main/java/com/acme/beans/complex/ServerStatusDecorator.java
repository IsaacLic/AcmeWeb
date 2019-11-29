package com.acme.beans.complex;


import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.ServerStatus;

/**
 * Abstract decorator for adding to the status description
 */
public abstract class ServerStatusDecorator extends ServerStatus {

    private final ServerStatus serverStatus;

    public ServerStatusDecorator(ServerStatus serverStatus) {
        this.serverStatus = serverStatus;
    }

    /**
     * gets the basic server status
     *
     * @return String the current basic server status
     */
    public String getStatusDesc() {
        return ServerManager.getCurrentServerStatus();
    }


    public long getId() {
        return serverStatus.getId();
    }

    public String getContentHeader() {

        return serverStatus.getContentHeader();
    }

}
