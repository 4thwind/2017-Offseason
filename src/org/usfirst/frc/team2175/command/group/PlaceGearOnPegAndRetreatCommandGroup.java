package org.usfirst.frc.team2175.command.group;

import org.usfirst.frc.team2175.command.BaseCommandGroup;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.RaiseGearIntakeCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeOutCommand;

public class PlaceGearOnPegAndRetreatCommandGroup extends BaseCommandGroup {
	public PlaceGearOnPegAndRetreatCommandGroup() {
		addSequential(new ActuateGearIntakeOutAndSpinCommand(), .3);
		addParallel(new RunGearIntakeOutCommand(), 1);
		addSequential(new DriveInAutonCommandGroup(0.7), 1);
		addSequential(new RaiseGearIntakeCommand());
	}
}
