package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class BallIntake_S extends Base_S {
	private CANTalon ballIntake;
	private final double intakeSpeed;
	private final double intakeReverseSpeed;

	public BallIntake_S() {
		ballIntake = makeMotor(Wiring_K.BALL_INTAKE);
		intakeSpeed = getSpeed(Behavior_K.BALL_INTAKE_SPEED);
		intakeReverseSpeed = getSpeed(Behavior_K.BALL_INTAKE_REVERSE_SPEED);
	}

	public void runIn() {
		ballIntake.set(intakeSpeed);
	}

	public void runOut() {
		ballIntake.set(intakeReverseSpeed);
	}

	public void stop() {
		ballIntake.set(0);
	}
}
