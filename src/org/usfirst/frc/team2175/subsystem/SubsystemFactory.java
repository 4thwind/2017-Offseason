package org.usfirst.frc.team2175.subsystem;

public class SubsystemFactory {
	public static void makeAll() {
		new DrivetrainSubsystem();
		new GearIntakeSubsystem();
		new ClimberSubsystem();
		new ShooterSubsystem();
	}
}
