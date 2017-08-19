package org.usfirst.frc.team2175.subsystem;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class ClimberSubsystem extends BaseSubsystem {
	private CANTalon motorOne;
	private CANTalon motorTwo;
	private double maxClimberSpeed;

	public ClimberSubsystem() {
		motorOne = new CANTalon(13);
		motorOne.reverseOutput(true);
		motorTwo = new CANTalon(14);
		motorTwo.changeControlMode(TalonControlMode.Follower);
		motorTwo.set(motorOne.getDeviceID());
		maxClimberSpeed = 1;
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
