package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.WiringKeys;

public class WiringProps {
	private static HashMap<String, String> wiringProps = new HashMap<>();
	private static boolean isC;

	public static HashMap<String, String> getWiringMap(boolean isComp) {
		isC = isComp;
		
		// put(HashMap, isCompBot, compInfo, pracInfo, id);
		put( "1, false", "1, false", WiringKeys.LEFT_MASTER);
		put( "2, false", "2, false",  WiringKeys.LEFT_SLAVEONE);
		put( "3, false", "2, false", WiringKeys.LEFT_SLAVETWO);
		put("4, false", "2, false", WiringKeys.RIGHT_MASTER);
		put("5, false", "2, false", WiringKeys.RIGHT_SLAVEONE);
		put("6, false", "2, false", WiringKeys.RIGHT_SLAVETWO);
		
		put("7, false", "2, false", WiringKeys.AGITATOR);
		put("8, false", "2, false", WiringKeys.SHOOTER);
		put("9, false", "2, false", WiringKeys.TURRET);
		
		put( "10, false", "2, false", WiringKeys.GEAR_INTAKE);
		
		put("11, false", "2, false", WiringKeys.CLIMBER_ONE);
		put("12, false", "2, false", WiringKeys.CLIMBER_TWO);
		
		return wiringProps;
	}
	
	private static void put( String compData, String pracData, String id) {
		String data = (isC) ? compData: pracData;
		// info.put(Identifier, String of id and isReversed);
		wiringProps.put(id, data);
	}
}
