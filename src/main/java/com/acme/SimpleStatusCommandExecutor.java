package com.acme;

import com.acme.beans.StatusInfo;
import org.springframework.context.annotation.Primary;

import java.util.LinkedList;
import java.util.Queue;

@Primary
public class SimpleStatusCommandExecutor implements IStatusCommandExecutor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }

}
