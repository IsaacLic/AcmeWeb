package com.acme.beans;

/**
 * Interface for an object containing the basic status information
 */
public interface StatusInfo {

    public long getId();

    public String getContentHeader();

    public String getStatusDesc();
}