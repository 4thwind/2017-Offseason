package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.keys.Wiring_K;

public class Wiring_I {
	private HashMap<String, String> wiringProps = new HashMap<>();

	public Wiring_I() {
		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(compInfo, pracInfo, id);
		put("1, false", Wiring_K.LEFT_MASTER);
		put("2, false", Wiring_K.LEFT_SLAVEONE);
		put("3, false", Wiring_K.LEFT_SLAVETWO);
		put("4, false", Wiring_K.RIGHT_MASTER);
		put("5, false", Wiring_K.RIGHT_SLAVEONE);
		put("6, false", Wiring_K.RIGHT_SLAVETWO);

		put("7, true", Wiring_K.AGITATOR);
		put("8, false", Wiring_K.SHOOTER_MASTER);
		put("9, true", Wiring_K.SHOOTER_SLAVE);
		put("10, false", Wiring_K.TURRET);
		put("11, true", Wiring_K.FEEDER);

		put("12, false", Wiring_K.CLIMBER);

		put("13, false", Wiring_K.BALL_INTAKE);

		put("0, 1", Wiring_K.DRIVE_SHIFTERS);

		put("3, 4, 1, false", Wiring_K.LEFT_ENCODER);
		put("1, 2, 1, false", Wiring_K.RIGHT_ENCODER);
		put("5, 6, 1, false", Wiring_K.TURRET_ENCODER);

		put("0", Wiring_K.TURRET_DIO);
	}

	public HashMap<String, String> getMap() {
		return wiringProps;
	}

	private void put(String data, String id) {
		wiringProps.put(id, data);
	}
}
