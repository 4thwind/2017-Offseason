package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Turret_S extends Base_S {
	private double maxTurretSpeed;
	// /private DigitalInput sensor;
	private CANTalon turret;
	private double[] offset;
	private boolean[] seesTarget;
	private boolean isAuto;
	private int offPos;
	private int seePos;

	public Turret_S() {
		turret = makeMotor(Wiring_K.TURRET);
		maxTurretSpeed = getSpeed(Behavior_K.TURRET_SPEED);
		offset = new double[100];
		seesTarget = new boolean[30];
		isAuto = true;
		offPos = 0;
		seePos = 0;
		// sensor = new DigitalInput(0);
	}

	public void turn(double turretTurnSpeed) {
		turret.set(turretTurnSpeed * maxTurretSpeed);
	}

	public void use(double offset) {
		if (offset == Math.pow(2175.0, 3)) {
			this.seesTarget[seePos % 30] = false;
		} else {
			this.seesTarget[seePos % 30] = true;
			this.offset[offPos % 100] = offset;
			offPos++;
		}
		seePos++;
	}

	public void turnAuto() {
		turret.set(3 * offset[offPos % 100] / 100);
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

	public boolean isSensorTriggered() {
		return false;
	}
}
