package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;

public class BallIntakeSubsystem extends BaseSubsystem {
	private CANTalon ballIntake;
	private final double intakeSpeed;
	private final double intakeReverseSpeed;

	public BallIntakeSubsystem() {
		ballIntake = makeMotor(WiringKeys.BALL_INTAKE);
		intakeSpeed = getSpeed(BehaviorKeys.BALL_INTAKE_SPEED);
		intakeReverseSpeed = getSpeed(BehaviorKeys.BALL_INTAKE_REVERSE_SPEED);
	}

	public void runIntakeIn() {
		ballIntake.set(intakeSpeed);
	}

	public void runIntakeOut() {
		ballIntake.set(intakeReverseSpeed);
	}
}
