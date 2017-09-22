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

		put("gamepad, 6", JoystickKeys.TURRET);
		put("gamepad, 7", JoystickKeys.SHOOT);
		put("gamepad, 8", JoystickKeys.AGITATE);

		put("gamepad, 270", JoystickKeys.POV_SHOOTER);
		put("gamepad, 90", JoystickKeys.POV_AGITATOR);
	}

	private void put(String data, String id) {
		joystickInfoMap.put(id, data);
	}

	public HashMap<String, String> getMap() {
		return joystickInfoMap;
	}
}
