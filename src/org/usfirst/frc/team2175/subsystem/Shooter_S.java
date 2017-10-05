package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Shooter_S extends Base_S {
	private CANTalon shooterMaster;
	private CANTalon shooterSlave;
	private CANTalon agitator;
	private CANTalon feeder;
	private double shooterSpeed;
	private double agitatorSpeed;
	private double feederSpeed;

	public Shooter_S() {
		shooterMaster = makeMotor(Wiring_K.SHOOTER_MASTER);
		shooterSlave = makeMotor(Wiring_K.SHOOTER_SLAVE);
		agitator = makeMotor(Wiring_K.AGITATOR);
		feeder = makeMotor(Wiring_K.ELEVATOR);
		shooterSpeed = getSpeed(Behavior_K.SHOOTER_SPEED);
		agitatorSpeed = getSpeed(Behavior_K.AGITATOR_SPEED);
		feederSpeed = getSpeed(Behavior_K.FEEDER_SPEED);

		setSlave(shooterSlave, shooterMaster);
	}

	public void runShooterPID() {
		shooterMaster.set(1800);
	}

	public void stopShooter() {
		shooterMaster.set(0);
	}

	public void runAgitator() {
		agitator.set(agitatorSpeed);
	}

	public void stopAgitator() {
		agitator.set(0);
	}

	public void runFeeder() {
		feeder.set(feederSpeed);
	}

	public void stopFeeder() {
		feeder.set(0);
	}

	public boolean isShooterSpinning() {
		return Math.abs(shooterMaster.get()) > 0;
	}
}
