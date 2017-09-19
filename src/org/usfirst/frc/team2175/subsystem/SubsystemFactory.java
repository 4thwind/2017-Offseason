package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.control.DriverStation;

public class SubsystemFactory {
	public static void makeAll() {
		new DrivetrainSubsystem();
		new GearIntakeSubsystem();
		new ClimberSubsystem();
		new DriverStation();
		new ShooterSubsystem();
		new TurretSubsystem();
	}
}
