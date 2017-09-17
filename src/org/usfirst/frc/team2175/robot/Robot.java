
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.command.DefaultCommandFactory;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.control.JoystickEventMapper;
import org.usfirst.frc.team2175.info.InfoLocator;
import org.usfirst.frc.team2175.subsystem.SubsystemFactory;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	@Override
	public void robotInit() {
		new InfoLocator();

		SubsystemFactory.makeAll();

		new DriverStation();

		DefaultCommandFactory.makeAll();

		new JoystickEventMapper();
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {

	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {

	}
}
