package com.acme.beans.complex;

import com.acme.BadRequestException;
import com.acme.DecoratorFactory;
import com.acme.beans.ServerStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Creates a decorated ServerStatus based on the details passed in
 */
@Component
@Primary
public class ComplexDecoratorFactory implements DecoratorFactory {

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

    @Override
    public ServerStatus createDecoratedStatus(ServerStatus serverStatus, List<String> details) {
        for (String detail : details) {
            serverStatus = decorateServerStatus(serverStatus, detail);
        }

        return serverStatus;
    }
}
