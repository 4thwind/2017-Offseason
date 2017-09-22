package org.usfirst.frc.team2175.control;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.single.RunAgitator_C;
import org.usfirst.frc.team2175.command.single.RunShooterPID_C;
import org.usfirst.frc.team2175.command.single.ShiftToHighGear_C;
import org.usfirst.frc.team2175.keys.Joystick_K;
public class JoystickEventMapper {

	public JoystickEventMapper() {
		DriverStation driverStation = ServiceLocator.get(DriverStation.class);

		driverStation.getButton(Joystick_K.SHIFT_GEARS)
				.whileHeld(new ShiftToHighGear_C());

		driverStation.getButton(Joystick_K.SHOOT)
				.toggleWhenPressed(new RunShooterPID_C());
		driverStation.getButton(Joystick_K.AGITATE)
				.toggleWhenPressed(new RunAgitator_C());
	}
}
