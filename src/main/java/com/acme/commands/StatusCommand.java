package com.acme.commands;

import com.acme.beans.StatusInfo;

public interface StatusCommand extends Command {

    @Override
    public StatusInfo getResult();
}
