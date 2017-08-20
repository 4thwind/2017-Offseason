
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.properties.PropertiesFactory;
import org.usfirst.frc.team2175.subsystem.SubsystemFactory;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	@Override
	public void robotInit() {
		PropertiesFactory.makeAll();
		SubsystemFactory.makeAll();

		new DriverStation();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {

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
