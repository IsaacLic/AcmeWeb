package com.acme;

import com.acme.beans.StatusInfo;

public interface Command {

    public StatusInfo determineStatus();

}
