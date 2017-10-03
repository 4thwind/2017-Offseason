package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticks_DC;
import org.usfirst.frc.team2175.command.single.RunClimber_DC;
import org.usfirst.frc.team2175.command.single.TurnTurret_DC;
import org.usfirst.frc.team2175.subsystem.Climber_S;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class Default_C_Factory {

	public static void makeAll() {
		ServiceLocator.get(Drivetrain_S.class)
				.setDefaultCommand(new ArcadeDriveWithJoysticks_DC());
		ServiceLocator.get(Turret_S.class)
				.setDefaultCommand(new TurnTurret_DC());
		ServiceLocator.get(Climber_S.class)
				.setDefaultCommand(new RunClimber_DC());
	}

}
