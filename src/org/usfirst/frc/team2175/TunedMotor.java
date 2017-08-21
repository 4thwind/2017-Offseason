package org.usfirst.frc.team2175;

import org.usfirst.frc.team2175.Info.BehaviorInfo;
import org.usfirst.frc.team2175.Info.MotorInfo;

import com.ctre.CANTalon;

public class TunedMotor {
	private BehaviorInfo behaviorInfo;
	private CANTalon motor;

	public TunedMotor(MotorInfo motorInfo, BehaviorInfo behaviorInfo) {
		this.behaviorInfo = behaviorInfo;
		motor = new CANTalon(motorInfo.deviceNumber);
		motor.reverseOutput(motorInfo.isInverted);
	}

	public void spinOut() {
		motor.set(behaviorInfo.outSpeed);
	}

	public void spinIn() {
		motor.set(behaviorInfo.inSpeed);
	}

	public void stop() {
		motor.set(0);
	}

	public boolean isRunning() {
		return motor.get() != 0;
	}
}
