package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.keys.Joystick_K;

public class Joystick_I {
	private HashMap<String, String> joystickInfoMap = new HashMap<>();

	public Joystick_I() {
		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(info, id);
		put("0", Joystick_K.LEFT_JOYSTICK);
		put("1", Joystick_K.RIGHT_JOYSTICK);
		put("2", Joystick_K.GAMEPAD);

		put("left, 1", Joystick_K.SHIFT_GEARS);

		put("gamepad, 1", Joystick_K.AUTO_AIM);
		put("gamepad, 7", Joystick_K.SHOOT);
		put("gamepad, 8", Joystick_K.AGITATE);
		put("gamepad, 4", Joystick_K.BALL_INTAKE);
	}

	private void put(String data, String id) {
		joystickInfoMap.put(id, data);
	}

	public HashMap<String, String> getMap() {
		return joystickInfoMap;
	}
}
