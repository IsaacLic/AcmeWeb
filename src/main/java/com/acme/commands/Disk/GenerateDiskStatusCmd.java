package com.acme.commands.Disk;

import com.acme.commands.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class GenerateDiskStatusCmd implements Command {

    private final static String[] diskCommand = new String[]{"cmd", "/C", "Dir", "/S", "C:\\*.java"};
    private String statusDesc = "unknown";

    @Override
    public void execute() {
        statusDesc = createStatusDesc();
    }

    @Override
    public String getResult() {
        return statusDesc;
    }

    /**
     * Generates the current status description
     * @return the current disk status
     */
    public String createStatusDesc() {
        String result = "";

        Runtime rt = Runtime.getRuntime();

        try {
            Process chkProcess = rt.exec(diskCommand);

            result = new BufferedReader(new InputStreamReader(chkProcess.getInputStream()))
                    .lines().collect(Collectors.joining("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
