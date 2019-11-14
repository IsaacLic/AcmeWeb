package statusmgr.beans;

import servermgr.ServerManager;

/**
 * Abstract decorator for adding to the status description
 */
public abstract class ServerStatusDecorator extends ServerStatus {

    public ServerStatusDecorator(ServerStatus serverStatus) {
    }

    /**
     * gets the basic server status
     *
     * @return String the current basic server status
     */
    public String getStatusDesc() {
        return ServerManager.getCurrentServerStatus();
    }

}
