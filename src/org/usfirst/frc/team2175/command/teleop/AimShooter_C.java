package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class AimShooter_C extends Base_C {
	private Turret_S turret_S;

	public AimShooter_C() {
		turret_S = get(Turret_S.class);
	}

	@Override
	protected void initialize() {
		turret_S.turnViaEncoder();
	}

	@Override
	protected void execute() {
		turret_S.turnAuto();
	}

	@Override
	protected boolean isFinished() {
		return turret_S.isEncoderCorrect();
	}
}
