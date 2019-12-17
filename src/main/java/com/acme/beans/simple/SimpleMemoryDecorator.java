package com.acme.beans.simple;

import com.acme.beans.ServerStatus;
import com.acme.beans.complex.ServerStatusDecorator;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Adds the detail about the memory to the ServerStatus. Hides the id and content header fields
 */
public class SimpleMemoryDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public SimpleMemoryDecorator(ServerStatus serverStatus) {
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
