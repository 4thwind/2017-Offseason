package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

public class RunShooter_C extends Base_C {
	Shooter_S shooter_S;

	public RunShooter_C() {
		shooter_S = get(Shooter_S.class);

		requires(shooter_S);
	}

	@Override
	public void initialize() {
		shooter_S.shoot();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		shooter_S.stop();
	}
}
