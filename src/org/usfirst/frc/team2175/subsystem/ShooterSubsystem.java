package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;
import org.usfirst.frc.team2175.info.InfoLocator;

import com.ctre.CANTalon;

public class ShooterSubsystem extends BaseSubsystem {
	InfoLocator locator;
	private CANTalon shooter;
	private CANTalon agitator;

	public ShooterSubsystem() {
		locator = ServiceLocator.get(InfoLocator.class);
		shooter = makeMotor(WiringKeys.SHOOTER);
		agitator = makeMotor(WiringKeys.AGITATOR);

	}

	public void runShooterPID() {
		shooter.set(3600);
	}

	public void stopShooter() {
		shooter.set(0);
	}

	public void runAgitator() {
		agitator.set(locator.getBehaviorInfo(BehaviorKeys.AGITATOR_SPEED));
	}

	public void stopAgitator() {
		agitator.set(0);
	}

	public boolean isShooterSpinning() {
		return Math.abs(shooter.get()) > 0;
	}
}
