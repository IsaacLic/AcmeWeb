package com.acme.beans;

import com.acme.Application;
import com.acme.servermgr.ServerManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * A POJO that represents Disk Status and can be used to generate JSON for that status
 */
public class DiskStatus implements StatusInfo {

    private long id;
    private String contentHeader;
    private String diskCommandOutput = "Unknown";

    private final static String[] diskCommand = new String[]{"cmd", "/C", "Dir", "/S", "C:*.java"};
    private String statusDesc;

    /**
     * Construct a DiskStatus using info passed in for identification.
     *
     * @param id            a numeric identifier/counter of which request this
     * @param contentHeader info about the request
     */
    public DiskStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;
    }

    public DiskStatus() {

    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {
        return contentHeader;
    }

    /**
     * Generates the current status description
     * @return the current disk status
     */
    public String createStatusDesc() {
        String result = "";

        Runtime rt = Runtime.getRuntime();

        try {
            Process chkProcess = rt.exec(diskCommand);

            result = new BufferedReader(new InputStreamReader(chkProcess.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }


}
