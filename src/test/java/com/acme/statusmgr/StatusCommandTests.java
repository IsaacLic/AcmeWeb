package com.acme.statusmgr;

import com.acme.beans.DiskStatus;
import com.acme.beans.ServerStatus;
import com.acme.beans.complex.ComplexDecoratorFactory;
import com.acme.commands.BasicDiskStatusCmd;
import com.acme.commands.BasicServerStatusCmd;
import com.acme.commands.DetailedServerStatusCmd;
import com.acme.executors.IStatusCommandExecutor;
import com.acme.executors.SimpleStatusCommandExecutor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StatusCommandTests {

    private static IStatusCommandExecutor executor;

    @Before
    public void setUp() {
        executor = new SimpleStatusCommandExecutor();
    }

    @Test
    public void basicServerStatusCommandShouldCreateBasicStatus() {

        BasicServerStatusCmd cmd = new BasicServerStatusCmd(5, "Server Status requested by %s", "Anonymous");

        executor.executeCommand(cmd);
        ServerStatus result = cmd.getResult();

        assertEquals(5, result.getId());
        assertEquals("Server Status requested by Anonymous", result.getContentHeader());
        assertEquals("Server is up", result.getStatusDesc());
    }

    @Test
    public void detailedServerStatusCommandShouldCreateDetailedStatus() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("memory");
        list.add("operations");
        list.add("extensions");
        list.add("memory");
        DetailedServerStatusCmd cmd = new DetailedServerStatusCmd(5, "Server Status requested by %s",
                "Anonymous", new ComplexDecoratorFactory(), list, "complex");

        executor.executeCommand(cmd);
        ServerStatus result = cmd.getResult();

        assertEquals(5, result.getId());
        assertEquals("Server Status requested by Anonymous", result.getContentHeader());
        assertEquals("Server is up, and its memory is Running low, and is operating normally, " +
                "and is using these extensions - [Hypervisor, Kubernetes, RAID-6], " +
                "and its memory is Running low", result.getStatusDesc());
    }

    @Test
    public void simplifiedDetailedServerStatusCommandShouldCreateSimplifiedStatus() {

        ArrayList<String> list = new ArrayList<String>();
        list.add("memory");
        list.add("operations");
        list.add("extensions");
        list.add("memory");
        DetailedServerStatusCmd cmd = new DetailedServerStatusCmd(5, "Server Status requested by %s",
                "Anonymous", new ComplexDecoratorFactory(), list, "simple");

        executor.executeCommand(cmd);
        ServerStatus result = cmd.getResult();

        assertEquals(0, result.getId());
        assertNull(result.getContentHeader());
        assertEquals("Server is up, and its memory is Running low, and is operating normally, " +
                "and is using these extensions - [Hypervisor, Kubernetes, RAID-6], " +
                "and its memory is Running low", result.getStatusDesc());
    }

    @Test
    public void basicDiskStatusCommandShouldCreateBasicStatus() {

        BasicDiskStatusCmd cmd = new BasicDiskStatusCmd(5, "Server Status requested by %s", "Anonymous");

        executor.executeCommand(cmd);
        DiskStatus result = cmd.getResult();

        assertEquals(5, result.getId());
        assertEquals("Server Status requested by Anonymous", result.getContentHeader());
    }
}
