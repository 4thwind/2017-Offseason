package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.ServiceLocator;

public class InfoLocator extends WiringInfo {
	private HashMap<String, String> wiringInfo;

	public InfoLocator() {
		wiringInfo = new HashMap<>();
		boolean isComp = true;
		fillWiringMap(isComp);
		ServiceLocator.register(this);
	}

	private void fillWiringMap(boolean isComp) {
		if (isComp) {
			fillWiringComp(wiringInfo);
		} else {
			fillWiringPrac(wiringInfo);
		}

	}

	public String getWiringInfo(String id) {
		return wiringInfo.get(id);
	}
}
