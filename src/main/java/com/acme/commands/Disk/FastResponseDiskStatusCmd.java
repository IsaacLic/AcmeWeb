package com.acme.commands.Disk;

import com.acme.beans.DiskStatus;

public class FastResponseDiskStatusCmd extends DiskStatusCmd {

    private final long Id;
    private final String template;
    private final String name;

    private DiskStatusCmd cmd;

    public FastResponseDiskStatusCmd(long Id, String template, String name, DiskStatusCmd cmd) {
        super(Id, template, name);

        this.Id = Id;
        this.template = template;
        this.name = name;
        this.cmd = cmd;
    }

    public FastResponseDiskStatusCmd(long Id, String template, String name) {
        this(Id, template, name, new DiskStatusCmd(Id, template, name));
    }

    @Override
    public void execute() {
        Thread executionThread = new Thread( () -> cmd.execute() );
        executionThread.start();
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DiskStatus getResult() {
        DiskStatus result = cmd.getResult();
        if (result == null || result.getStatusDesc() == null){
            result = new DiskStatus(Id, String.format(template, name));
            result.setStatusDesc("Unknown");
        }
        return result;
    }
}
