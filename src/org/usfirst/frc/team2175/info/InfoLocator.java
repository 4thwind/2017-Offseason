package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class InfoLocator {
	private HashMap<String, String> wiringInfoMap;
	private HashMap<String, String> joystickInfoMap;
	private HashMap<String, Double> behaviorInfoMap;
	private boolean isComp = true;

	public InfoLocator() {
		makeInfoMaps();
		ServiceLocator.register(this);
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

	private void makeInfoMaps() {
		BehaviorInfo behaviorInfo = new BehaviorInfo();
		behaviorInfoMap = behaviorInfo.getMap();
		JoystickInfo joystickInfo = new JoystickInfo();
		joystickInfoMap = joystickInfo.getMap();
		WiringInfo wiringInfo = new WiringInfo(isComp);
		wiringInfoMap = wiringInfo.getMap();

	}
}
