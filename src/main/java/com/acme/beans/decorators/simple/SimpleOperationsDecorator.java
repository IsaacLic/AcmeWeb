package com.acme.beans.decorators.simple;

import com.acme.beans.decorators.complex.ServerStatusDecorator;
import com.acme.beans.ServerStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Adds the detail about the operations to the ServerStatus. Hides the id and content header fields
 */
public class SimpleOperationsDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public SimpleOperationsDecorator(ServerStatus serverStatus) {
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
        if (serverManager.isOperatingNormally()) {
            operationStatusMessage = "operating normally";
        } else {
            operationStatusMessage = "not operating normally";

        }
        return serverStatus.getStatusDesc() + ", and is " + operationStatusMessage;
    }

    /**
     * prevents the ID field from being displayed
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public long getId() {
        return 0;
    }

    /**
     * prevents the content header from being displayed
     */
    @Override
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public String getContentHeader() {
        return null;
    }
}
