package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.WiringKeys;

public class WiringInfo {
	private HashMap<String, String> wiringProps = new HashMap<>();
	private static boolean isC;

	public WiringInfo(boolean isComp) {
		isC = isComp;

		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(compInfo, pracInfo, id);
		put("1, false", "1, false", WiringKeys.LEFT_MASTER);
		put("2, false", "2, false", WiringKeys.LEFT_SLAVEONE);
		put("3, false", "3, false", WiringKeys.LEFT_SLAVETWO);
		put("4, false", "4, false", WiringKeys.RIGHT_MASTER);
		put("5, false", "5, false", WiringKeys.RIGHT_SLAVEONE);
		put("6, false", "6, false", WiringKeys.RIGHT_SLAVETWO);

		put("7, false", "7, false", WiringKeys.AGITATOR);
		put("8, false", "8, false", WiringKeys.SHOOTER);
		put("9, false", "9, false", WiringKeys.TURRET);

		put("10, false", "10, false", WiringKeys.GEAR_INTAKE);

		put("11, false", "11, false", WiringKeys.CLIMBER);

		put("12, false", "12, false", WiringKeys.BALL_INTAKE);

		put("single, 5", "single, 5", WiringKeys.DRIVE_SHIFTERS);
		put("double, 4, 3", "double, 4, 3", WiringKeys.GEAR_ACTUATOR);

		put("0", "0", WiringKeys.GYRO);

		put("2, 3, true", "2, 3, true", WiringKeys.LEFT_ENCODER);
		put("0, 1, true", "0, 1, true", WiringKeys.RIGHT_ENCODER);
	}

	public HashMap<String, String> getMap() {
		return wiringProps;
	}

	private void put(String compData, String pracData, String id) {
		String data = (isC) ? compData : pracData;
		// info.put(Identifier, String of id and isReversed);
		wiringProps.put(id, data);
	}
}
