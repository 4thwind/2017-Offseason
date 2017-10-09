package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class BallIntake_S extends Base_S {
	private final double intakeReverseSpeed;
	private final double intakeSpeed;
	private CANTalon ballIntake;

	public BallIntake_S() {
		intakeReverseSpeed = getSpeed(Behavior_K.BALL_INTAKE_REVERSE_SPEED);
		intakeSpeed = getSpeed(Behavior_K.BALL_INTAKE_SPEED);
		ballIntake = makeMotor(Wiring_K.BALL_INTAKE);
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