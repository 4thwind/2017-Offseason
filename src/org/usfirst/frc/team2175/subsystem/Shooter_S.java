package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.info.I_Locator;
import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Shooter_S extends Base_S {
	I_Locator locator;
	private CANTalon shooter;
	private CANTalon agitator;

	public Shooter_S() {
		locator = ServiceLocator.get(I_Locator.class);
		shooter = makeMotor(Wiring_K.SHOOTER);
		agitator = makeMotor(Wiring_K.AGITATOR);

	}

	public void runShooterPID() {
		shooter.set(3600);
	}

	public void stopShooter() {
		shooter.set(0);
	}

	public void runAgitator() {
		agitator.set(locator.getBehaviorInfo(Behavior_K.AGITATOR_SPEED));
	}

	public void stopAgitator() {
		agitator.set(0);
	}

	public boolean isShooterSpinning() {
		return Math.abs(shooter.get()) > 0;
	}
}
