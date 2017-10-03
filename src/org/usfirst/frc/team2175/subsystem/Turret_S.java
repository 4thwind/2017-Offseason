package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;

public class Turret_S extends Base_S {
	private double maxTurretSpeed;
	private DigitalInput inputOne;
	private DigitalInput inputTwo;
	private CANTalon turret;
	private double[] offset;
	private boolean isAuto;
	private int pos;

	public Turret_S() {
		turret = makeMotor(Wiring_K.TURRET);
		maxTurretSpeed = getSpeed(Behavior_K.TURRET_SPEED);
		isAuto = true;
		pos = 0;
	}

	public void turn(double turretTurnSpeed) {
		turret.set(turretTurnSpeed * maxTurretSpeed);
	}

	public void use(double offset) {
		this.offset[pos++] = offset;
	}

	public void turnAuto() {
		turret.set(3 * offset[pos] / 100);
	}

	public boolean isAutoAim() {
		return isAuto;
	}

	public void toggleAuto() {
		isAuto = !isAuto;
	}

	public void turnManual(double speed) {
		turret.set(speed);
	}

	public void stop() {
		turret.set(0);
	}
}
