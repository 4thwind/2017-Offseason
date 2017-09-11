package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.WiringKeys;

public class WiringInfo {
	private static boolean isCompetitionBot;

	protected static void fillWiringMap(boolean isComp,
			HashMap<String, String> wiringInfo) {
		isCompetitionBot = isComp;
		
		// put(HashMap, compInfo, pracInfo, id);
		put(wiringInfo, "1, false", "1, false", WiringKeys.LEFT_MASTER);
		put(wiringInfo, "2, false", "2, false",  WiringKeys.LEFT_SLAVEONE);
		put(wiringInfo, "2, false", "2, false", WiringKeys.LEFT_SLAVETWO);
		put(wiringInfo, "2, false", "2, false", WiringKeys.RIGHT_MASTER);
		put(wiringInfo, "2, false", "2, false", WiringKeys.RIGHT_SLAVEONE);
		put(wiringInfo, "2, false", "2, false", WiringKeys.RIGHT_SLAVETWO);
		
		put(wiringInfo, "2, false", "2, false", WiringKeys.AGITATOR);
		put(wiringInfo, "2, false", "2, false", WiringKeys.SHOOTER);
		put(wiringInfo, "2, false", "2, false", WiringKeys.TURRET);
		
		put(wiringInfo, "2, false", "2, false", WiringKeys.GEAR_INTAKE);
		
		put(wiringInfo, "2, false", "2, false", WiringKeys.CLIMBER_ONE);
		put(wiringInfo, "2, false", "2, false", WiringKeys.CLIMBER_TWO);
	}

	private static void put(HashMap<String, String> wiringInfo, String compData, String pracData, String id) {
		String data = (isCompetitionBot) ? compData: pracData;
		// wiringInfo.put(Identifier, String of id and isReversed);
		wiringInfo.put(id, data);
	}
}
