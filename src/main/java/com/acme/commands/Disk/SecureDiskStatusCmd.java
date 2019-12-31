package com.acme.commands.Disk;

import com.acme.beans.DiskStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Proxy decorator for ensuring that only registered users can execute the disk status command
 */
public class SecureDiskStatusCmd extends DiskStatusCmd {
    private final long Id;
    private final String template;
    private final String name;

    private DiskStatusCmd cmd;

    protected static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public SecureDiskStatusCmd(long Id, String template, String name, DiskStatusCmd cmd) {
        super(Id, template, name);

        this.Id = Id;
        this.template = template;
        this.name = name;
        this.cmd = cmd;
    }

    public SecureDiskStatusCmd(long Id, String template, String name) {
        this(Id, template, name, new DiskStatusCmd(Id, template, name));
    }

    @Override
    public void execute() {
        if (name == null || name.equals("Anonymous")) {
            return;
        }

        LOGGER.info("User '{}' was allowed to access disk status information", name);

        cmd.execute();
    }

    @Override
    public DiskStatus getResult() {
        return cmd.getResult();
    }
}
