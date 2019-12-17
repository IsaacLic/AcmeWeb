package com.acme.beans.decorators;

import com.acme.beans.ServerStatus;

import java.util.List;

public interface DecoratorFactory {

    public ServerStatus createDecoratedStatus (ServerStatus serverStatus, List<String> details);
}
