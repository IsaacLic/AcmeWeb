package com.acme.commands.Disk;

import com.acme.beans.DiskStatus;
import com.acme.commands.StatusCommand;
import com.acme.executors.ICommandExecutor;
import com.acme.executors.SimpleCommandExecutor;

/**
 * Command for determining the basic disk status
 */
public class DiskStatusCmd implements StatusCommand {

    private ICommandExecutor executor;

    private final long Id;
    private final String template;
    private final String name;
    private final GenerateDiskStatusCmd cmd;

    private DiskStatus status;

    public DiskStatusCmd(long Id, String template, String name, GenerateDiskStatusCmd cmd) {
        this.Id = Id;
        this.template = template;
        this.name = name;
        this.cmd = cmd;

        executor = new SimpleCommandExecutor();
    }

    public DiskStatusCmd(long Id, String template, String name) {
        this(Id, template, name, new GenerateDiskStatusCmd());
    }

    @Override
    public void execute() {
        executor.executeCommand(cmd);
        status = new DiskStatus(Id, String.format(template, name));
        status.setStatusDesc(cmd.getResult());
    }

    @Override
    public DiskStatus getResult() {
        return status;
    }
}
