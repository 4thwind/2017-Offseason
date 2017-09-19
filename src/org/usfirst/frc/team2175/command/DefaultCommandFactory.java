package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticksCommand;
import org.usfirst.frc.team2175.command.single.RunClimberCommand;
import org.usfirst.frc.team2175.command.single.TurnTurretCommand;
import org.usfirst.frc.team2175.subsystem.ClimberSubsystem;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;
import org.usfirst.frc.team2175.subsystem.TurretSubsystem;

public class DefaultCommandFactory {

	public static void makeAll() {
		ServiceLocator.get(DrivetrainSubsystem.class)
				.setDefaultCommand(new ArcadeDriveWithJoysticksCommand());
		ServiceLocator.get(ClimberSubsystem.class)
				.setDefaultCommand(new RunClimberCommand());
		ServiceLocator.get(TurretSubsystem.class)
				.setDefaultCommand(new TurnTurretCommand());
	}

}
