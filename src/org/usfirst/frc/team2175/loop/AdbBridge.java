package org.usfirst.frc.team2175.loop;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdbBridge {
    Path bin_location;
    public final static Path DEFAULT_LOCATION = Paths.get("/usr/bin/adb");

    public AdbBridge() {
         bin_location = DEFAULT_LOCATION;
 
    }
    
    public String getOutput(String args) {
    	Runtime r = Runtime.getRuntime();
    	String cmd = bin_location.toString() + " " + args;
    	
    	Process p = null;
		try {
			p = r.exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(String.valueOf(p.getOutputStream()));
    	return String.valueOf(p.getOutputStream());
    }

    private boolean runCommand(String args) {
        Runtime r = Runtime.getRuntime();
        String cmd = bin_location.toString() + " " + args;

        try {
            Process p = r.exec(cmd);
            p.waitFor();
        } catch (IOException e) {
            System.err.println("AdbBridge: Could not run command " + cmd);
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            System.err.println("AdbBridge: Could not run command " + cmd);
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void start() {
        System.out.println("Starting adb");
        runCommand("start-server");
    }

    public void stop() {
        System.out.println("Stopping adb");
        runCommand("kill-server");
    }

    public void restartAdb() {
        System.out.println("Restarting adb");
        stop();
        start();
    }

    public void portForward(int local_port, int remote_port) {
        runCommand("forward tcp:" + local_port + " tcp:" + remote_port);
    }
}
