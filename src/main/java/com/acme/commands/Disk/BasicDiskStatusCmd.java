package com.acme.commands.Disk;

import com.acme.beans.DiskStatus;
import com.acme.commands.Command;

/**
 * Command for determining the basic disk status
 */
public class BasicDiskStatusCmd implements Command {

    private final long Id;
    private final String template;
    private final String name;

    private DiskStatus status;

    public BasicDiskStatusCmd(long Id, String template, String name) {
        this.Id = Id;
        this.template = template;
        this.name = name;
    }

    @Override
    public void execute() {
        status = new DiskStatus(Id, String.format(template, name));
        status.setStatusDesc(status.createStatusDesc());
    }

    @Override
    public DiskStatus getResult() {
        return status;
    }
}
