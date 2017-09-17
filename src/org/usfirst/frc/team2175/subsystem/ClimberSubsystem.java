package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class ClimberSubsystem extends BaseSubsystem {
	private CANTalon motorOne;
	private CANTalon motorTwo;
	private double maxClimberSpeed;

	public ClimberSubsystem() {
		motorOne = makeMotor(WiringKeys.CLIMBER_ONE);
		motorTwo = makeMotor(WiringKeys.CLIMBER_TWO);

		motorTwo.changeControlMode(TalonControlMode.Follower);
		motorTwo.set(motorOne.getDeviceID());
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
