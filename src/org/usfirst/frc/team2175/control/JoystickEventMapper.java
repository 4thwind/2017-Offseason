package org.usfirst.frc.team2175.control;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.EmptyCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ActuateShooterCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.RunGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.ShiftToHighGearCommand;
import org.usfirst.frc.team2175.command.single.ToggleGearIntakeActuationCommand;
import org.usfirst.frc.team2175.identifiers.ButtonIDs;

public class JoystickEventMapper {

	public JoystickEventMapper() {
		DriverStation driverStation = ServiceLocator.get(DriverStation.class);

		driverStation.getButton(ButtonIDs.SHIFT_GEARS)
				.whileHeld(new ShiftToHighGearCommand());

		driverStation.getButton(ButtonIDs.ACTUATE_SHOOTER)
				.toggleWhenPressed(new ActuateShooterCommand());
		driverStation.getButton(ButtonIDs.SHOOT_OUT)
				.whileHeld(new EmptyCommand());
		driverStation.getButton(ButtonIDs.FEED_OUT)
				.whileHeld(new EmptyCommand());

		driverStation.getButton(ButtonIDs.GEAR_IN)
				.whileHeld(new RunGearIntakeInCommand());
		driverStation.getButton(ButtonIDs.GEAR_OUT)
				.whileHeld(new RunGearIntakeOutCommand());
		driverStation.getButton(ButtonIDs.ACTUATE_GEAR)
				.toggleWhenPressed(new ToggleGearIntakeActuationCommand());
		driverStation.getButton(ButtonIDs.GEAR_OUT_SPIN)
				.whileHeld(new ActuateGearIntakeOutAndSpinCommand());

	}
}
