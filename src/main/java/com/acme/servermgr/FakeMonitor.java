package com.acme.servermgr;

/**
 * Implement a fake server monitor such as would be used for unit tests, annotated as a Spring Service.
 */
public class FakeMonitor implements MonitorableServer {
    @Override
    public String determineServerStatus() {
        return "Server is up";
    }
}