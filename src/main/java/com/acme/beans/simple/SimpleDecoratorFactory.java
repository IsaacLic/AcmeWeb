package com.acme.beans.simple;

import com.acme.BadRequestException;
import com.acme.DecoratorFactory;
import com.acme.statusmgr.beans.ServerStatus;

import java.util.List;

/**
 * Creates a decorated ServerStatus based on the details passed in. Hides the id and content header fields
 */
public class SimpleDecoratorFactory implements DecoratorFactory {

    /**
     * selects which server status detail to be added, then adds it
     *
     * @param serverStatus the server status to be added to
     * @param detail       which detail to add
     * @return the augmented server status
     */
    private ServerStatus decorateServerStatus(ServerStatus serverStatus, String detail) {
        switch (detail) {
            case "extensions":
                return new SimpleExtensionsDecorator(serverStatus);
            case "memory":
                return new SimpleMemoryDecorator(serverStatus);
            case "operations":
                return new SimpleOperationsDecorator(serverStatus);
            default:
                throw new BadRequestException("Invalid details option: " + detail);
        }
    }

    @Override
    public ServerStatus createDecoratedStatus(ServerStatus serverStatus, List<String> details) {
        for (String detail : details) {
            serverStatus = decorateServerStatus(serverStatus, detail);
        }

        return serverStatus;
    }
}
