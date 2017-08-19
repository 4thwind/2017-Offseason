package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.control.DriverStation;

public class SubsystemFactory {

	public static void makeAll() {
		new ClimberSubsystem();
		new DrivetrainSubsystem();
		new GearIntakeSubsystem();
		new DriverStation();
		new ShooterSubsystem();
		new VisionSubsystem();
	}
}
