package com.acme.commands.Disk;

/**
 * Singleton proxy for generating the disk status, so that only one instance of the command will be executed at once
 */
public class ResourceEfficientDiskStatusGenerationCmd extends GenerateDiskStatusCmd {

    private String statusDesc = "unknown";

    private boolean isRunning;
    private static ResourceEfficientDiskStatusGenerationCmd cmd = new ResourceEfficientDiskStatusGenerationCmd();

    private ResourceEfficientDiskStatusGenerationCmd() {
    }

    public static ResourceEfficientDiskStatusGenerationCmd getInstance(){
        return cmd;
    }

    @Override
    public void execute() {

        boolean willExecute;
        synchronized (this){
            if (isRunning){
                willExecute = false;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                isRunning = true;
                willExecute = true;
            }
        }

        if (willExecute){
            statusDesc = super.createStatusDesc();
            synchronized (this){
                isRunning = false;
                this.notifyAll();
            }
        }

    }

    @Override
    public String getResult() {
        return statusDesc;
    }

}
