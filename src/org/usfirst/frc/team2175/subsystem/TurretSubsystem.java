package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;

public class TurretSubsystem extends BaseSubsystem {
	private CANTalon turret;
	private double turretSpeed;

	public TurretSubsystem() {
		turret = makeMotor(WiringKeys.TURRET);
		turretSpeed = getSpeed(BehaviorKeys.TURRET_SPEED);
	}

	public void turnLeft() {
		turret.set(turretSpeed);
	}

	public void turnRight() {
		turret.set(turretSpeed);
	}
}
