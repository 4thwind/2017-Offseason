
package org.usfirst.frc.team2175.robot;

import org.usfirst.frc.team2175.info.WiringInfo;
import org.usfirst.frc.team2175.subsystem.SubsystemFactory;

import edu.wpi.first.wpilibj.IterativeRobot;

public class Robot extends IterativeRobot {

	@Override
	public void robotInit() {
		new WiringInfo();
		SubsystemFactory.makeAll();

		// new DriverStation();

		// DefaultCommandFactory.makeAll();

		// new JoystickEventMapper();
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
