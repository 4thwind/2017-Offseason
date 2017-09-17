package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.subsystem.GearIntakeSubsystem;

public class SpinGearIntakeInCommand extends BaseCommand {

	private final GearIntakeSubsystem gearIntakeSubsystem;

	public SpinGearIntakeInCommand() {
		gearIntakeSubsystem = ServiceLocator.get(GearIntakeSubsystem.class);
		requires(gearIntakeSubsystem);
	}

	@Override
	protected void execute() {
		gearIntakeSubsystem.spinIn();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		gearIntakeSubsystem.stop();
	}

}
