package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class I_Locator {
	private HashMap<String, String> wiringInfoMap;
	private HashMap<String, String> joystickInfoMap;
	private HashMap<String, Double> behaviorInfoMap;

	public I_Locator() {
		makeInfoMaps();
		ServiceLocator.register(this);
	}

	private void makeInfoMaps() {
		Behavior_I behaviorInfo = new Behavior_I();
		behaviorInfoMap = behaviorInfo.getMap();
		Joystick_I joystickInfo = new Joystick_I();
		joystickInfoMap = joystickInfo.getMap();
		Wiring_I wiringInfo = new Wiring_I();
		wiringInfoMap = wiringInfo.getMap();
	}

	public Double getBehaviorInfo(String id) {
		return behaviorInfoMap.get(id);
	}

	public String getJoystickInfo(String id) {
		return joystickInfoMap.get(id);
	}

	public String getWiringInfo(String id) {
		return wiringInfoMap.get(id);
	}
}
