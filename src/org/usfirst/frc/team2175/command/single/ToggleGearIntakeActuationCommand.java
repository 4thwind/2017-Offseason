package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

public class ToggleGearIntakeActuationCommand extends BaseCommand {

	GearIntakeSubsystem gearIntakeSubsystem;

	public ToggleGearIntakeActuationCommand() {
		gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
		requires(gearIntakeSubsystem);
	}

	@Override
	protected void initialize() {
		gearIntakeSubsystem.toggleActuation();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
