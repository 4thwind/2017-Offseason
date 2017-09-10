package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class InfoLocator {
	private HashMap<String, String> wiringInfo;
	private final boolean isComp = true;

	public InfoLocator() {
		makeWiringInfoMap();
		ServiceLocator.register(this);
	}

	private void makeWiringInfoMap() {
		wiringInfo = new HashMap<>();
		WiringInfo.fillWiringMap(isComp, wiringInfo);
	}

	public String getWiringInfo(String id) {
		return wiringInfo.get(id);
	}
}
