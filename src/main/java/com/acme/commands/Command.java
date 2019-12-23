package com.acme.commands;

import com.acme.beans.StatusInfo;

public interface Command {

    public void execute();

    public StatusInfo getResult();

}
