
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Default_C_Factory;
import org.usfirst.frc.team2175.control.JoystickEventMapper;
import org.usfirst.frc.team2175.info.I_Locator;
import org.usfirst.frc.team2175.loop.AndroidInfo_L;
import org.usfirst.frc.team2175.loop.Scheduler_L;
import org.usfirst.frc.team2175.loop.SmartDashboard_L;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;
import org.usfirst.frc.team2175.subsystem.S_Factory;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	Scheduler_L schedulerLoop = new Scheduler_L();
	SmartDashboard_L smartDashboardLoop;
	AndroidInfo_L androidInfoLoop;
	Drivetrain_S drivetrainSubsystem;
	Command auton;

	@Override
	public void robotInit() {
		makeSystems();
		makeLoops();
	}

	private void makeSystems() {
		new I_Locator();
		S_Factory.makeAll();

		Default_C_Factory.makeAll();

		drivetrainSubsystem = ServiceLocator.get(Drivetrain_S.class);
	}

	private void makeLoops() {
		schedulerLoop.start();
		smartDashboardLoop = new SmartDashboard_L();
		smartDashboardLoop.start();
		androidInfoLoop = new AndroidInfo_L();
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
		new JoystickEventMapper();
		if (auton != null && auton.isRunning()) {
			auton.cancel();
		}
		drivetrainSubsystem.resetSensors();
	}

	@Override
	public void teleopPeriodic() {
	}
}
