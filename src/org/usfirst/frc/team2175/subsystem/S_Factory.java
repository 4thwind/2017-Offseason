package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.control.DriverStation;

public class S_Factory {
	public static void makeAll() {
		new Drivetrain_S();
		new Climber_S();
		new DriverStation();
		new Shooter_S();
		new Turret_S();
		new BallIntake_S();
	}
}
