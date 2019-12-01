package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.BadRequestException;
import com.acme.beans.ExtensionsDecorator;
import com.acme.beans.MemoryDecorator;
import com.acme.beans.OperationsDecorator;
import com.acme.beans.ServerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    @RequestMapping("/status")
    public ServerStatus getCurrentServerStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                               @RequestParam(required = false) List<String> details) {
        System.out.println("*** DEBUG INFO ***" + details);
        return new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));
    }

    /**
     * gets detailed information about the server status
     *
     * @param name    the name of the source of the status request
     * @param details the desired details about the server status
     * @return the detailed server status
     */
    @RequestMapping("/status/detailed")
    public ServerStatus getCurrentDetailedServerStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                                       @RequestParam List<String> details) {
        ServerStatus serverStatus = new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));

        for (String detail : details) {
            serverStatus = decorateServerStatus(serverStatus, detail);
        }

        return serverStatus;
    }

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
