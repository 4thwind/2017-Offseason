package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;

public class TurretSubsystem extends BaseSubsystem {
	private CANTalon turret;
	private double maxTurretSpeed;
	private double[] offset;
	private int pos;

	public TurretSubsystem() {
		turret = makeMotor(WiringKeys.TURRET);
		maxTurretSpeed = getSpeed(BehaviorKeys.TURRET_SPEED);
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
