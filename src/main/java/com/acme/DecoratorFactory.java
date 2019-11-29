package com.acme;

import com.acme.statusmgr.beans.ServerStatus;

import java.util.List;

public interface DecoratorFactory {

    public ServerStatus createDecoratedStatus (ServerStatus serverStatus, List<String> details);
}
