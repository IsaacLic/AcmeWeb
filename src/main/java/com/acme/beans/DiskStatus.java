package com.acme.beans;

/**
 * A POJO that represents Disk Status and can be used to generate JSON for that status
 */
public class DiskStatus implements StatusInfo {

    private long id;
    private String contentHeader;
    private String diskCommandOutput = "Unknown";

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

    @Override
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String getStatusDesc() {
        return statusDesc;
    }


}
