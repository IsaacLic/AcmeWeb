package com.acme.commands;

import com.acme.BadRequestException;
import com.acme.DecoratorFactory;
import com.acme.beans.ServerStatus;
import com.acme.beans.complex.ComplexDecoratorFactory;
import com.acme.beans.simple.SimpleDecoratorFactory;

import java.util.List;

public class DetailedServerStatusCmd implements Command {

    private final long Id;
    private final String template;
    private final String name;
    private DecoratorFactory decoratorFactory;
    private final List<String> details;
    private final String levelOfDetail;

    private ServerStatus status;

    public DetailedServerStatusCmd(long Id, String template, String name, DecoratorFactory decoratorFactory, List<String> details, String levelOfDetail) {
        this.Id = Id;
        this.template = template;
        this.name = name;
        this.decoratorFactory = decoratorFactory;
        this.details = details;
        this.levelOfDetail = levelOfDetail;
    }

    @Override
    public void execute() {

        setDecoratorFactory();

        status = new ServerStatus(Id, String.format(template, name));
        status = decoratorFactory.createDecoratedStatus(status, details);

        status.setStatusDesc(status.createStatusDesc());
    }

    @Override
    public ServerStatus getResult() {
        return status;
    }

    private void setDecoratorFactory() {
        if (levelOfDetail == null) {
            return;
        }

        if (levelOfDetail.equals("complex")) {
            decoratorFactory = new ComplexDecoratorFactory();
            return;
        }

        if (levelOfDetail.equals("simple")) {
            decoratorFactory = new SimpleDecoratorFactory();
            return;
        }

        throw new BadRequestException("Invalid level of detail.");
    }
}
