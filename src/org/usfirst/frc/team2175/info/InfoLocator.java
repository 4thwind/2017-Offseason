package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class InfoLocator {
	private HashMap<String, String> wiringInfo;
	private boolean isComp = true;

	public InfoLocator() {
		makeWiringInfoMap();
		ServiceLocator.register(this);
	}

	public String getWiringInfo(String id) {
		return wiringInfo.get(id);
	}

	private void makeWiringInfoMap() {
		WiringProps wiringProps = new WiringProps();
		wiringInfo = wiringProps.getWiringMap(isComp);
	}
}
