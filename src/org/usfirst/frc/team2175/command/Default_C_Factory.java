package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.ArcadeDriveWithJoysticks_C;
import org.usfirst.frc.team2175.command.single.RunClimber_C;
import org.usfirst.frc.team2175.subsystem.Climber_S;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;

public class Default_C_Factory {

	public static void makeAll() {
		ServiceLocator.get(Drivetrain_S.class)
				.setDefaultCommand(new ArcadeDriveWithJoysticks_C());
		ServiceLocator.get(Climber_S.class)
				.setDefaultCommand(new RunClimber_C());
	}

}
