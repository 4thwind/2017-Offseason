package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.keys.Wiring_K;

public class Wiring_I {
	private HashMap<String, String> wiringProps = new HashMap<>();
	private static boolean isC;

	public Wiring_I(boolean isComp) {
		isC = isComp;

		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(compInfo, pracInfo, id);
		put("1, false", "1, false", Wiring_K.LEFT_MASTER);
		put("2, false", "2, false", Wiring_K.LEFT_SLAVEONE);
		put("3, false", "3, false", Wiring_K.LEFT_SLAVETWO);
		put("4, false", "4, false", Wiring_K.RIGHT_MASTER);
		put("5, false", "5, false", Wiring_K.RIGHT_SLAVEONE);
		put("6, false", "6, false", Wiring_K.RIGHT_SLAVETWO);

		put("7, false", "7, false", Wiring_K.AGITATOR);
		put("8, false", "8, false", Wiring_K.SHOOTER);
		put("9, false", "9, false", Wiring_K.TURRET);
		put("10, false", "10, false", Wiring_K.ELEVATOR);

		put("11, false", "11, false", Wiring_K.CLIMBER);

		put("12, false", "12, false", Wiring_K.BALL_INTAKE);

		put("single, 5", "single, 5", Wiring_K.DRIVE_SHIFTERS);

		put("0", "0", Wiring_K.GYRO);

		put("2, 3, true", "2, 3, true", Wiring_K.LEFT_ENCODER);
		put("0, 1, true", "0, 1, true", Wiring_K.RIGHT_ENCODER);
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
