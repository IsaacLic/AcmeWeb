package com.acme.servermgr;

import org.springframework.stereotype.Component;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple methods for use in school project
 */
@Component
public class ServerManager {

    /**
     * Reference to a class that knows how to get details about what we are interested in on a server
     */
    private MonitorableServer monitor;

    /**
     * Get the status of this server
     *
     * @return a descriptive string about the servers status
     */
    public String getCurrentServerStatus() {

        String status = monitor.determineServerStatus();

        return status;
    }

    /**
     * Find out if this server is operating normally
     *
     * @return Boolean indicating if server is operating normally
     */
    public Boolean isOperatingNormally() {
        return true;
    }   //TODO should eventually use the monitor interface

    /**
     * Find out what the current memory status is
     *
     * @return String the message about the memory status
     */
    public String getMemoryStatus() {
        return "memory is Running low";
    }    //TODO should eventually use the monitor interface

    /**
     * gets the extensions currently in use
     *
     * @return the extensions in use
     */
    public String getExtensions() {
        return "[Hypervisor, Kubernetes, RAID-6]";
    }   //TODO should eventually use the monitor interface
}
