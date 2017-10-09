package org.usfirst.frc.team2175.control;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.info.I_Locator;
import org.usfirst.frc.team2175.keys.Joystick_K;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
	private HashMap<String, JoystickButton> buttonMap;
	private I_Locator locator;

	private Joystick leftJoystick;
	private Joystick rightJoystick;
	private Joystick gamepad;

	public DriverStation() {
		locator = ServiceLocator.get(I_Locator.class);
		leftJoystick = makeJoystick(Joystick_K.LEFT_JOYSTICK);
		rightJoystick = makeJoystick(Joystick_K.RIGHT_JOYSTICK);
		gamepad = makeJoystick(Joystick_K.GAMEPAD);

		buttonMap = new HashMap<>();
		registerToMap();

		ServiceLocator.register(this);
	}

	private Joystick makeJoystick(String id) {
		int port = Integer.parseInt(locator.getJoystickInfo(id));
		return new Joystick(port);
	}

	private void registerToMap() {
		createButton(Joystick_K.SHIFT_GEARS);

		createButton(Joystick_K.SHOOT);
		createButton(Joystick_K.AGITATE);
		createButton(Joystick_K.AUTO_AIM);
		createButton(Joystick_K.BALL_INTAKE);
	}

	private void createButton(String id) {
		String[] data = locator.getJoystickInfo(id).split(",");
		JoystickButton button = new JoystickButton(
				joystickForName(data[0].trim()),
				Integer.parseInt(data[1].trim()));
		buttonMap.put(id, button);
	}

	private Joystick joystickForName(final String name) {
		Joystick joystickOfChoice = null;
		switch (name) {
			case "left" :
				joystickOfChoice = leftJoystick;
				break;
			case "right" :
				joystickOfChoice = rightJoystick;
				break;
			case "gamepad" :
				joystickOfChoice = gamepad;
				break;
			default :
				final String msg = "Joystick name parameter is not valid. Joystick name is="
						+ name;
				throw new IllegalArgumentException(msg);
		}
		return joystickOfChoice;
	}

	public JoystickButton getButton(String key) {
		return buttonMap.get(key);
	}

	public double getMoveValue() {
		return getOutput(leftJoystick.getY(), .1);
	}

	public double getTurnValue() {
		return rightJoystick.getX();
	}

	public double getClimberSpinSpeed() {
		return gamepad.getRawAxis(1);
	}

	public double getTurretTurnSpeed() {
		return gamepad.getRawAxis(2);
	}

	public double getOutput(final double input, final double deadbandSize) {
		double output = 0;
		if (Math.abs(input) >= deadbandSize) {
			double slope = 1 / (1 - deadbandSize);
			double sign = Math.signum(input);
			output = slope * sign * (Math.abs(input) - deadbandSize);
		}
		return output;
	}
}
