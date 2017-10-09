package org.usfirst.frc.team2175.loop;

import edu.wpi.first.wpilibj.command.Command;

public class LoopManager {
	Scheduler_L schedulerLoop = new Scheduler_L();
	SmartDashboard_L smartDashboardLoop;
	AndroidInfo_L androidInfoLoop;

	public LoopManager() {
		schedulerLoop.start();
		smartDashboardLoop = new SmartDashboard_L();
		smartDashboardLoop.start();
		androidInfoLoop = new AndroidInfo_L();
		androidInfoLoop.start();
	}

	public Command getAuton() {
		return smartDashboardLoop.getAuton();
	}
}
