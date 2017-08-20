package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorIDs;
import org.usfirst.frc.team2175.identifiers.MotorIDs;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class ClimberSubsystem extends BaseSubsystem {
	private CANTalon motorOne;
	private CANTalon motorTwo;
	private double maxClimberSpeed;

	public ClimberSubsystem() {
		motorOne = motorFromInfoID(MotorIDs.CLIMBER_ONE);
		motorTwo = motorFromInfoID(MotorIDs.CLIMBER_TWO);
		motorTwo.changeControlMode(TalonControlMode.Follower);
		motorTwo.set(motorOne.getDeviceID());
		maxClimberSpeed = getBehaviorInfo(BehaviorIDs.CLIMBER).inSpeed;
	}

	public double getMaxClimberSpeed() {
		return maxClimberSpeed;
	}

	public void setClimberSpeed(double speed) {
		if (speed > 0 && speed <= 1) {
			motorOne.set(speed);
		} else {
			motorTwo.set(0);
		}
	}
}
