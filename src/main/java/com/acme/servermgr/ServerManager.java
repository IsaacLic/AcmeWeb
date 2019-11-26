package com.acme.servermgr;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project
 */
public class ServerManager {

    /**
     * Get the status of this server
     *
     * @return a descriptive string about the servers status
     */
    static public String getCurrentServerStatus() {
        return "Server is up";
    }

    /**
     * Find out if this server is operating normally
     *
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally() {
        return true;
    }

    /**
     * Find out what the current memory status is
     *
     * @return String the message about the memory status
     */
    static public String getMemoryStatus() {
        return "memory is Running low";
    }

    /**
     * gets the extensions currently in use
     *
     * @return the extensions in use
     */
    public static String getExtensions() {
        return "[Hypervisor, Kubernetes, RAID-6]";
    }
}
