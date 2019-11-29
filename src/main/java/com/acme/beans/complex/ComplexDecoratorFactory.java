package com.acme.beans.complex;

import com.acme.BadRequestException;
import com.acme.statusmgr.beans.ServerStatus;

public class ComplexDecoratorFactory {


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
                return new ExtensionsDecorator(serverStatus);
            case "memory":
                return new MemoryDecorator(serverStatus);
            case "operations":
                return new OperationsDecorator(serverStatus);
            default:
                throw new BadRequestException("Invalid details option: " + detail);
        }
    }
}
