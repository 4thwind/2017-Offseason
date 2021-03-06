package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Shooter_S extends Base_S {
	private CANTalon shooterMaster;
	private CANTalon shooterSlave;
	private CANTalon agitator;
	private CANTalon feeder;
	private double agitatorSpeed;
	private double shooterSpeed;
	private double feederSpeed;

	public Shooter_S() {
		shooterMaster = makeMotor(Wiring_K.SHOOTER_MASTER);
		shooterSlave = makeMotor(Wiring_K.SHOOTER_SLAVE);
		agitator = makeMotor(Wiring_K.AGITATOR);
		feeder = makeMotor(Wiring_K.FEEDER);

		agitatorSpeed = getSpeed(Behavior_K.AGITATOR_SPEED);
		shooterSpeed = getSpeed(Behavior_K.SHOOTER_SPEED);
		feederSpeed = getSpeed(Behavior_K.FEEDER_SPEED);

		setSlave(shooterSlave, shooterMaster);

		shooterMaster.setPID(0.195, 0.0, 0.5, 0.014, 5000, 0, 0);
		shooterMaster.setProfile(0);
		shooterMaster.reverseSensor(false);

		setUpMotor(shooterMaster);
		setUpMotor(shooterSlave);
	}

	private void setUpMotor(CANTalon motor) {
		motor.setVoltageRampRate(36.0);
		motor.enableBrakeMode(false);
		motor.clearStickyFaults();
	}

	public void shoot() {
		setRpm(shooterSpeed);
	}

	private void setRpm(double rpm) {
		shooterMaster.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooterMaster.set(rpm);
	}

	public void stop() {
		shooterMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		shooterMaster.set(0);
	}

	public double getRpm() {
		return shooterMaster.getSpeed();
	}

	public void feed(double time) {
		double multiplier = getMultiplier(time);
		feeder.set(feederSpeed);
		agitator.set(multiplier * agitatorSpeed);
	}

	private double getMultiplier(double time) {
		return (time < 4) ? time * .25 : 1;
	}

	public void stopFeeding() {
		feeder.set(0);
		agitator.set(0);
	}

	public boolean isShooterSpinning() {
		return Math.abs(shooterMaster.get()) > 0;
	}
}
