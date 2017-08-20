package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class ShiftToHighGearCommand extends BaseCommand {

	private final DrivetrainSubsystem drivetrainSubsystem;

	public ShiftToHighGearCommand() {
		drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
	}

	@Override
	protected void initialize() {
		super.initialize();
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
