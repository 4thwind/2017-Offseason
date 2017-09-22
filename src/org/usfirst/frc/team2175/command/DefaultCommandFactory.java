package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticksCommand;
import org.usfirst.frc.team2175.command.single.RunClimberCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class DefaultCommandFactory {

	public static void makeAll() {
		ServiceLocator.get(DrivetrainSubsystem.class)
				.setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
		ServiceLocator.get(ClimberSubsystem.class)
				.setDefaultCommand(new RunClimberCommand());
	}

}
