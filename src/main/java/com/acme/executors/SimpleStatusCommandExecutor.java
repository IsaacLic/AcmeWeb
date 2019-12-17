package com.acme.executors;

import com.acme.commands.Command;
import org.springframework.context.annotation.Primary;

@Primary
public class SimpleStatusCommandExecutor implements IStatusCommandExecutor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }

}
