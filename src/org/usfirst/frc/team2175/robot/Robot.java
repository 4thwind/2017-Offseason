
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Default_C_Factory;
import org.usfirst.frc.team2175.control.JoystickEventMapper;
import org.usfirst.frc.team2175.info.I_Locator;
import org.usfirst.frc.team2175.loop.Scheduler_L;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;
import org.usfirst.frc.team2175.subsystem.S_Factory;
import org.usfirst.frc.team2175.subsystem.Turret_S;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;

public class Robot extends IterativeRobot {
	Drivetrain_S drivetrainSubsystem;
	Turret_S turret_S;
	Command auton;

	Scheduler_L schedulerLoop = new Scheduler_L();

	@Override
	public void robotInit() {
		makeSystems();
		new JoystickEventMapper();
		schedulerLoop.start();
	}

	private void makeSystems() {
		new I_Locator();
		S_Factory.makeAll();

		Default_C_Factory.makeAll();

		drivetrainSubsystem = ServiceLocator.get(Drivetrain_S.class);
	}

	@Override
	public void autonomousInit() {
		drivetrainSubsystem.resetSensors();

		// auton = loopManager.getAuton();
		// Scheduler.getInstance().add(auton);
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
