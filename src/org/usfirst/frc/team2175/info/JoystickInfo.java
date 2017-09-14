package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.JoystickKeys;

public class JoystickInfo {
	private HashMap<String, String> joystickInfoMap = new HashMap<>();

	public JoystickInfo() {

		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		put("0", JoystickKeys.LEFT_JOYSTICK);
		put("1", JoystickKeys.RIGHT_JOYSTICK);
		put("2", JoystickKeys.GAMEPAD);
		// put(info, id);
		put("left, 1", JoystickKeys.SHIFT_GEARS);
		put("left, 2", JoystickKeys.GEAR_IN_DRIVER);
		put("left, 4", JoystickKeys.LOWER_GEAR_DRIVER);
		put("left, 5", JoystickKeys.RAISE_GEAR_DRIVER);

		put("right, 1", JoystickKeys.GEAR_OUT_SPIN_DRIVER);

		put("gamepad, 1", JoystickKeys.GEAR_OUT_SPIN);
		put("gamepad, 2", JoystickKeys.ACTUATE_GEAR);
		put("gamepad, 3", JoystickKeys.GEAR_IN);
		put("gamepad, 4", JoystickKeys.GEAR_OUT);
		put("gamepad, 6", JoystickKeys.AGITATE);
		put("gamepad, 7", JoystickKeys.SHOOT);
		put("gamepad, 8", JoystickKeys.FEED);
		put("gamepad, 10", JoystickKeys.ACTUATE_SHOOTER);

		put("gamepad, 270", JoystickKeys.POV_SHOOTER);

	}

	public HashMap<String, String> getMap() {
		return joystickInfoMap;
	}

	private void put(String data, String id) {
		joystickInfoMap.put(id, data);
	}
}
