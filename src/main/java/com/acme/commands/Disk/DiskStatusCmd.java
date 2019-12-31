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

    private DiskStatus status;

    public DiskStatusCmd(long Id, String template, String name) {
        this.Id = Id;
        this.template = template;
        this.name = name;
        executor = new SimpleCommandExecutor();
    }

    @Override
    public void execute() {
        GenerateDiskStatusCmd cmd = new GenerateDiskStatusCmd();
        executor.executeCommand(cmd);
        status = new DiskStatus(Id, String.format(template, name));
        status.setStatusDesc(cmd.getResult());
    }

    @Override
    public DiskStatus getResult() {
        return status;
    }
}
