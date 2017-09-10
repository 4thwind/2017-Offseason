package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.WiringKeys;

public class WiringInfo {

	protected void fillWiringPrac(HashMap<String, String> wiringInfo) {
		// wiringInfo.put(Identifier, String of id, isReversed);
		wiringInfo.put(WiringKeys.LEFT_MASTER, "1, false");
		wiringInfo.put(WiringKeys.LEFT_SLAVEONE, "2, false");
		wiringInfo.put(WiringKeys.LEFT_SLAVETWO, "3, false");
		wiringInfo.put(WiringKeys.RIGHT_MASTER, "4, false");
		wiringInfo.put(WiringKeys.RIGHT_SLAVEONE, "5, false");
		wiringInfo.put(WiringKeys.RIGHT_SLAVETWO, "6, false");

		wiringInfo.put(WiringKeys.AGITATOR, "7, false");
		wiringInfo.put(WiringKeys.SHOOTER, "8, false");
		wiringInfo.put(WiringKeys.TURRET, "9, false");

		wiringInfo.put(WiringKeys.GEAR_INTAKE, "10, false");

		wiringInfo.put(WiringKeys.CLIMBER_ONE, "11, false");
		wiringInfo.put(WiringKeys.CLIMBER_TWO, "12, false");
	}

	protected void fillWiringComp(HashMap<String, String> wiringInfo) {
		// wiringInfo.put(Identifier, String of id, isReversed);
		wiringInfo.put(WiringKeys.LEFT_MASTER, "1, false");
		wiringInfo.put(WiringKeys.LEFT_SLAVEONE, "2, false");
		wiringInfo.put(WiringKeys.LEFT_SLAVETWO, "3, false");
		wiringInfo.put(WiringKeys.RIGHT_MASTER, "4, false");
		wiringInfo.put(WiringKeys.RIGHT_SLAVEONE, "5, false");
		wiringInfo.put(WiringKeys.RIGHT_SLAVETWO, "6, false");

		wiringInfo.put(WiringKeys.AGITATOR, "7, false");
		wiringInfo.put(WiringKeys.SHOOTER, "8, false");
		wiringInfo.put(WiringKeys.TURRET, "9, false");

		wiringInfo.put(WiringKeys.GEAR_INTAKE, "10, false");

		wiringInfo.put(WiringKeys.CLIMBER_ONE, "11, false");
		wiringInfo.put(WiringKeys.CLIMBER_TWO, "12, false");
	}
}
