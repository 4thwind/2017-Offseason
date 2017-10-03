package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.keys.Behavior_K;

public class Behavior_I {
	private HashMap<String, Double> behaviorInfoMap;

	public Behavior_I() {
		behaviorInfoMap = new HashMap<>();

		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(info, id);
		put(1.0, Behavior_K.CLIMBER_MAX_SPEED);

		put(0.6, Behavior_K.AGITATOR_SPEED);
		put(-0.6, Behavior_K.AGITATOR_REVERSE_SPEED);
		put(0.3, Behavior_K.TURRET_SPEED);
		put(0.57, Behavior_K.SHOOTER_SPEED);
		put(-0.25, Behavior_K.SHOOTER_REVERSE_SPEED);
		put(0.5, Behavior_K.FEEDER_SPEED);
		put(0.7, Behavior_K.BALL_INTAKE_SPEED);
		put(-0.7, Behavior_K.BALL_INTAKE_REVERSE_SPEED);

		put(45.0, Behavior_K.GYRO_TURNCORRECTION);
		put(20.0, Behavior_K.THRESHOLD_CURRENT);
		put(40.21, Behavior_K.TICK_CONVERSION);

		put(0.05, Behavior_K.GYRO_P);
		put(0.0, Behavior_K.GYRO_I);
		put(0.0, Behavior_K.GYRO_D);
		put(0.0, Behavior_K.GYRO_F);

	}

	public HashMap<String, Double> getMap() {
		return behaviorInfoMap;
	}

	private void put(Double data, String id) {
		behaviorInfoMap.put(id, data);
	}
}
