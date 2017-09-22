package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Turret_S extends Base_S {
	private CANTalon turret;
	private double maxTurretSpeed;
	private double[] offset;
	private int pos;

	public Turret_S() {
		turret = makeMotor(Wiring_K.TURRET);
		maxTurretSpeed = getSpeed(Behavior_K.TURRET_SPEED);
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
}
