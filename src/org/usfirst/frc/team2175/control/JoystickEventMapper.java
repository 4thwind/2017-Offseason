package org.usfirst.frc.team2175.control;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.teleop.AimShooter_C;
import org.usfirst.frc.team2175.command.teleop.RunAgitation_C;
import org.usfirst.frc.team2175.command.teleop.RunBallIntakeIn_C;
import org.usfirst.frc.team2175.command.teleop.RunShooter_C;
import org.usfirst.frc.team2175.command.teleop.ShiftToHighGear_C;
import org.usfirst.frc.team2175.keys.Joystick_K;

public class JoystickEventMapper {

	public JoystickEventMapper() {
		DriverStation driverStation = ServiceLocator.get(DriverStation.class);

		driverStation.getButton(Joystick_K.SHIFT_GEARS)
				.whileHeld(new ShiftToHighGear_C());

		driverStation.getButton(Joystick_K.SHOOT)
				.toggleWhenPressed(new RunShooter_C());
		driverStation.getButton(Joystick_K.AGITATE)
				.toggleWhenPressed(new RunAgitation_C());
		driverStation.getButton(Joystick_K.BALL_INTAKE)
				.toggleWhenPressed(new RunBallIntakeIn_C());
		driverStation.getButton(Joystick_K.AUTO_AIM)
				.whenPressed(new AimShooter_C());
	}
}
