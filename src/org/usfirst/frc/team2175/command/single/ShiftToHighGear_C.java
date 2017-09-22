package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;

public class ShiftToHighGear_C extends Base_C {
	private Drivetrain_S drivetrainSubsystem;

	public ShiftToHighGear_C() {
		drivetrainSubsystem = ServiceLocator.get(Drivetrain_S.class);
	}

	@Override
	protected void initialize() {
		drivetrainSubsystem.shiftToHighGear();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrainSubsystem.shiftToLowGear();
	}
}
