package com.acme.beans.simple;

import com.acme.DecoratorFactory;
import com.acme.statusmgr.beans.ServerStatus;

import java.util.List;

public class SimpleDecoratorFactory implements DecoratorFactory {

    @Override
    public ServerStatus createDecoratedStatus(ServerStatus serverStatus, List<String> details) {
        return null; //TODO
    }
}
