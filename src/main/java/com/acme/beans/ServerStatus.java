package com.acme.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus implements StatusInfo {

    private long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * This will refer to an instance of the ServerManager class (no longer static)
     */
    protected ServerManager serverManager;

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate Manager class.
     *
     * @param id            a numeric identifier/counter of which request this
     * @param contentHeader info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain and save reference to the ServerManager
        serverManager = (ServerManager) Application.getApplicationContext().getBean("serverManager");
    }

    public ServerStatus() {

    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getContentHeader() {

        return contentHeader;
    }

    /**
     * Generates the current status description
     * @return the current server status
     */
    @Override
    public String createStatusDesc() {
        return serverManager.getCurrentServerStatus();
    }

    @Override
    public void setStatusDesc(String statusDesc){
        this.statusDesc = statusDesc;
    }

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }

}
