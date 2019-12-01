package com.acme.beans;

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
        if (serverStatus.serverManager.isOperatingNormally()) {
            operationStatusMessage = "operating normally";
        } else {
            operationStatusMessage = "not operating normally";

        }
        return serverStatus.getStatusDesc() + ", and is " + operationStatusMessage;
    }
}
