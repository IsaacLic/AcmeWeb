package com.acme.executors;

import com.acme.commands.Command;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SimpleCommandExecutor implements ICommandExecutor {

    @Override
    public void executeCommand(Command command) {
        command.execute();
    }

}
