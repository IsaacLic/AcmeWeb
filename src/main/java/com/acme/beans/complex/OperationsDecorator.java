package com.acme.beans.complex;

import com.acme.beans.ServerStatus;

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
    public String createStatusDesc() {
        String operationStatusMessage;
        if (serverManager.isOperatingNormally()) {
            operationStatusMessage = "operating normally";
        } else {
            operationStatusMessage = "not operating normally";

        }
        return serverStatus.createStatusDesc() + ", and is " + operationStatusMessage;
    }
}
