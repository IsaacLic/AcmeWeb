package com.acme.commands.Disk;

import com.acme.beans.DiskStatus;
import com.acme.commands.StatusCommand;
import com.acme.executors.ICommandExecutor;
import com.acme.executors.SimpleCommandExecutor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Command for determining the basic disk status
 */
public class BasicDiskStatusCmd implements StatusCommand {

    private ICommandExecutor executor;

    private final long Id;
    private final String template;
    private final String name;

    private DiskStatus status;

    public BasicDiskStatusCmd(long Id, String template, String name) {
        this.Id = Id;
        this.template = template;
        this.name = name;
        executor = new SimpleCommandExecutor();
    }

    @Override
    public void execute() {
        status = new DiskStatus(Id, String.format(template, name));
        GenerateDiskStatusCmd cmd = new GenerateDiskStatusCmd();
        executor.executeCommand(cmd);
        status.setStatusDesc(cmd.getResult());
    }

    @Override
    public DiskStatus getResult() {
        return status;
    }
}
