
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Default_C_Factory;
import org.usfirst.frc.team2175.control.JoystickEventMapper;
import org.usfirst.frc.team2175.info.I_Locator;
import org.usfirst.frc.team2175.loop.LoopManager;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;
import org.usfirst.frc.team2175.subsystem.S_Factory;
import org.usfirst.frc.team2175.subsystem.Turret_S;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
	LoopManager loopManager;
	Drivetrain_S drivetrainSubsystem;
	Turret_S turret_S;
	Command auton;

	@Override
	public void robotInit() {
		loopManager = new LoopManager();
		makeSystems();
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

		auton = loopManager.getAuton();
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
