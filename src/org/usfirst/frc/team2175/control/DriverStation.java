package org.usfirst.frc.team2175.control;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.identifiers.JoystickKeys;
import org.usfirst.frc.team2175.info.InfoLocator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriverStation {
	private HashMap<String, JoystickButton> buttonMap;
	private InfoLocator locator;
	private Joystick leftJoystick;
	private Joystick rightJoystick;
	private Joystick gamepad;

	public DriverStation() {
		locator = ServiceLocator.get(InfoLocator.class);
		leftJoystick = makeJoystick(JoystickKeys.LEFT_JOYSTICK);
		rightJoystick = makeJoystick(JoystickKeys.RIGHT_JOYSTICK);
		gamepad = makeJoystick(JoystickKeys.GAMEPAD);

		buttonMap = new HashMap<>();
		registerButtonsToMap();

		ServiceLocator.register(this);
	}

	private Joystick makeJoystick(String id) {
		int port = Integer.parseInt(locator.getJoystickInfo(id));
		return new Joystick(port);
	}

	private void registerButtonsToMap() {
		JoystickKeys jKeys = new JoystickKeys();
		for (Field field : jKeys.getClass().getDeclaredFields()) {
			try {
				if (field.toString().contains("button")) {
					createButtonFromInfo(
							locator.getJoystickInfo(field.toString()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void createButtonFromInfo(String id) {
		System.out.println(id);
		String[] data = id.split(",");
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
		return leftJoystick.getY();
	}

	public double getTurnValue() {
		return rightJoystick.getX();
	}

	public double getClimberSpinSpeed() {
		return gamepad.getRawAxis(1) * .1;
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
