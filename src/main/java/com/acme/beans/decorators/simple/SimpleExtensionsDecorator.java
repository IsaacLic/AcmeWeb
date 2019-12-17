package com.acme.beans.decorators.simple;

import com.acme.beans.decorators.complex.ServerStatusDecorator;
import com.acme.beans.ServerStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Adds the detail about the extensions to the ServerStatus. Hides the id and content header fields
 */
public class SimpleExtensionsDecorator extends ServerStatusDecorator {

    private final ServerStatus serverStatus;

    public SimpleExtensionsDecorator(ServerStatus serverStatus) {
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
