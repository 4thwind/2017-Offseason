package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Climber_S extends Base_S {
	private CANTalon motorOne;
	private double maxClimberSpeed;

	public Climber_S() {
		motorOne = makeMotor(Wiring_K.CLIMBER);

		maxClimberSpeed = getSpeed(Behavior_K.CLIMBER_MAX_SPEED);
	}

	public void setClimberSpeed(double speed) {
		double correctSpeed = (speed > 0) ? speed * maxClimberSpeed : 0;
		motorOne.set(correctSpeed);
	}

	public double getOutputCurrent() {
		return motorOne.getOutputCurrent();
	}
}
