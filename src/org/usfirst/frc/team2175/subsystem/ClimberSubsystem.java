package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;

public class ClimberSubsystem extends BaseSubsystem {
	private CANTalon motorOne;
	private double maxClimberSpeed;

	public ClimberSubsystem() {
		motorOne = makeMotor(WiringKeys.CLIMBER);

		maxClimberSpeed = getSpeed(BehaviorKeys.CLIMBER_MAX_SPEED);
	}

	public void setClimberSpeed(double speed) {
		double correctSpeed = (speed > 0) ? speed : 0;
		motorOne.set(correctSpeed);
	}

	public double getMaxClimberSpeed() {
		return maxClimberSpeed;
	}

	public double getOutputCurrent() {
		return motorOne.getOutputCurrent();
	}
}
