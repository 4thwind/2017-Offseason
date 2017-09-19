
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.control.JoystickEventMapper;
import org.usfirst.frc.team2175.info.InfoLocator;
import org.usfirst.frc.team2175.loop.AndroidInfoLoop;
import org.usfirst.frc.team2175.loop.SchedulerLoop;
import org.usfirst.frc.team2175.loop.SmartDashboardLoop;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.SubsystemFactory;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	SchedulerLoop schedulerLoop = new SchedulerLoop();
	SmartDashboardLoop smartDashboardLoop;
	AndroidInfoLoop androidInfoLoop;
	DrivetrainSubsystem drivetrainSubsystem;
	Command auton;

	@Override
	public void robotInit() {
		makeSystems();
		makeLoops();
	}

	private void makeSystems() {
		new InfoLocator();
		SubsystemFactory.makeAll();

		DefaultCommandFactory.makeAll();

		new JoystickEventMapper();
		drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
	}

	private void makeLoops() {
		schedulerLoop.start();
		smartDashboardLoop = new SmartDashboardLoop();
		smartDashboardLoop.start();
		androidInfoLoop = new AndroidInfoLoop();
		androidInfoLoop.start();
	}

	@Override
	public void autonomousInit() {
		drivetrainSubsystem.resetSensors();
		auton = smartDashboardLoop.getAuton();
		Scheduler.getInstance().add(auton);
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopInit() {
		if (auton != null && auton.isRunning()) {
			auton.cancel();
		}
		drivetrainSubsystem.resetSensors();
	}

	@Override
	public void teleopPeriodic() {
	}
}
