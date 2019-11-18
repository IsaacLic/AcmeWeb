package com.acme.beans;


import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.ServerStatus;

/**
 * Abstract decorator for adding to the status description
 */
public abstract class ServerStatusDecorator extends ServerStatus {

    public ServerStatusDecorator(ServerStatus serverStatus) {
    }

    /**
     * gets the basic server status
     *
     * @return String the current basic server status
     */
    public String getStatusDesc() {
        return ServerManager.getCurrentServerStatus();
    }

}
