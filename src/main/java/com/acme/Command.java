package com.acme;

import com.acme.beans.StatusInfo;

public interface Command {

    public void execute();

    public StatusInfo determineStatus();

}
