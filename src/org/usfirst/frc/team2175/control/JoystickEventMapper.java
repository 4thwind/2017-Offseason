package org.usfirst.frc.team2175.control;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.EmptyCommand;
import org.usfirst.frc.team2175.command.single.ActuateGearIntakeOutAndSpinCommand;
import org.usfirst.frc.team2175.command.single.ShiftToHighGearCommand;
import org.usfirst.frc.team2175.command.single.SpinGearIntakeInCommand;
import org.usfirst.frc.team2175.command.single.SpinGearIntakeOutCommand;
import org.usfirst.frc.team2175.command.single.ToggleGearIntakeActuationCommand;
import org.usfirst.frc.team2175.identifiers.JoystickKeys;
public class JoystickEventMapper {

	public JoystickEventMapper() {
		DriverStation driverStation = ServiceLocator.get(DriverStation.class);

		driverStation.getButton(JoystickKeys.SHIFT_GEARS)
				.whileHeld(new ShiftToHighGearCommand());

		driverStation.getButton(JoystickKeys.SHOOT)
				.whileHeld(new EmptyCommand());
		driverStation.getButton(JoystickKeys.FEED)
				.whileHeld(new EmptyCommand());

		driverStation.getButton(JoystickKeys.GEAR_IN)
				.whileHeld(new SpinGearIntakeInCommand());
		driverStation.getButton(JoystickKeys.GEAR_OUT)
				.whileHeld(new SpinGearIntakeOutCommand());
		driverStation.getButton(JoystickKeys.ACTUATE_GEAR)
				.toggleWhenPressed(new ToggleGearIntakeActuationCommand());
		driverStation.getButton(JoystickKeys.GEAR_OUT_SPIN)
				.whileHeld(new ActuateGearIntakeOutAndSpinCommand());

	}
}
