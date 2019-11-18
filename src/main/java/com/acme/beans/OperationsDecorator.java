package com.acme.beans;

import com.acme.beans.ServerStatusDecorator;
import com.acme.servermgr.ServerManager;
import com.acme.statusmgr.beans.ServerStatus;

/**
 * Adds the detail about the operations to the ServerStatus
 */
public class OperationsDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public OperationsDecorator(ServerStatus serverStatus) {
        super(serverStatus);

        this.serverStatus = serverStatus;
    }

    /**
     * Adds the operations information to the status description
     *
     * @return the detailed status description
     */
    public String getStatusDesc() {
        String operationStatusMessage;
        if (ServerManager.isOperatingNormally()) {
            operationStatusMessage = "operating normally";
        } else {
            operationStatusMessage = "not operating normally";

        }
        return serverStatus.getStatusDesc() + ", and is " + operationStatusMessage;
    }
}
