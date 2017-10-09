package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

public class RunAgitation_C extends Base_C {
	Shooter_S shooter_S;

	public RunAgitation_C() {
		shooter_S = get(Shooter_S.class);
	}

	@Override
	protected void initialize() {
		if (shooter_S.isShooterSpinning()) {
			shooter_S.feed();
		}
	}

	@Override
	protected boolean isFinished() {
		return !shooter_S.isShooterSpinning();
	}

	@Override
	protected void end() {
		shooter_S.stopFeeding();
	}

}
