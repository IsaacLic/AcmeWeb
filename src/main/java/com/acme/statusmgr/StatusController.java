package com.acme.statusmgr;

import com.acme.BadRequestException;
import com.acme.DecoratorFactory;
import com.acme.commands.BasicServerStatusCmd;
import com.acme.executors.IStatusCommandExecutor;
import com.acme.beans.DiskStatus;
import com.acme.beans.ServerStatus;
import com.acme.beans.complex.ComplexDecoratorFactory;
import com.acme.beans.simple.SimpleDecoratorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


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

    @Autowired
    private DecoratorFactory decoratorFactory;

    @Autowired
    private IStatusCommandExecutor statusCommandExecutor;

    @RequestMapping("/status")
    public ServerStatus getCurrentServerStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                               @RequestParam(required = false) List<String> details) {
        System.out.println("*** DEBUG INFO ***" + details);
        BasicServerStatusCmd cmd = new BasicServerStatusCmd(counter.incrementAndGet(), template, name);
        statusCommandExecutor.executeCommand(cmd);
        return cmd.getResult();
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
                                                       @RequestParam List<String> details,
                                                       @RequestParam(value = "levelofdetail", required = false) String levelOfDetail) {
        ServerStatus serverStatus = new ServerStatus(counter.incrementAndGet(),
                String.format(template, name));

        setDecoratorFactory(levelOfDetail);

        serverStatus = decoratorFactory.createDecoratedStatus(serverStatus, details);

        return serverStatus;
    }

    private void setDecoratorFactory(String levelOfDetail) {
        if (levelOfDetail == null){
            return;
        }

        if (levelOfDetail.equals("complex")){
            decoratorFactory = new ComplexDecoratorFactory();
            return;
        }

        if (levelOfDetail.equals("simple")){
            decoratorFactory = new SimpleDecoratorFactory();
            return;
        }

        throw new BadRequestException("Invalid level of detail.");
    }

    @RequestMapping("/disk/status")
    public DiskStatus getCurrentDiskStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {
        return new DiskStatus(counter.incrementAndGet(),
                String.format(template, name));
    }

}
