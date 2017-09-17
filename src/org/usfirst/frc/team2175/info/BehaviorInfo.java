package org.usfirst.frc.team2175.info;

import java.util.HashMap;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;

public class BehaviorInfo {
	private HashMap<String, Double> behaviorInfoMap;

	public BehaviorInfo() {
		behaviorInfoMap = new HashMap<>();

		fillMapWithInfo();
	}

	private void fillMapWithInfo() {
		// put(info, id);
		put(1.0, BehaviorKeys.CLIMBER_MAX_SPEED);

		put(0.7, BehaviorKeys.GEAR_IN_SPEED);
		put(0.5, BehaviorKeys.GEAR_OUT_SPEED);

		put(0.6, BehaviorKeys.AGITATOR_SPEED);
		put(-0.6, BehaviorKeys.AGITATOR_REVERSE_SPEED);
		put(0.3, BehaviorKeys.TURRET_SPEED);
		put(0.57, BehaviorKeys.SHOOTER_SPEED);
		put(-0.25, BehaviorKeys.SHOOTER_REVERSE_SPEED);

		put(45.0, BehaviorKeys.GYRO_TURNCORRECTION);
		put(20.0, BehaviorKeys.THRESHOLD_CURRENT);
		put(40.21, BehaviorKeys.TICK_CONVERSION);

		put(0.05, BehaviorKeys.GYRO_P);
		put(0.0, BehaviorKeys.GYRO_I);
		put(0.0, BehaviorKeys.GYRO_D);
		put(0.0, BehaviorKeys.GYRO_F);

	}

	public HashMap<String, Double> getMap() {
		return behaviorInfoMap;
	}

	private void put(Double data, String id) {
		behaviorInfoMap.put(id, data);
	}
}
