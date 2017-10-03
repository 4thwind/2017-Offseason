package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

public class RunAgitator_C extends Base_C {
	Shooter_S shooter_S;

	public RunAgitator_C() {
		shooter_S = ServiceLocator.get(Shooter_S.class);
	}

	@Override
	protected void initialize() {
		shooter_S.runFeeder();
		shooter_S.runAgitator();
	}

	@Override
	protected boolean isFinished() {
		return !shooter_S.isShooterSpinning();
	}

	@Override
	protected void end() {
		shooter_S.stopAgitator();
		shooter_S.runFeeder();
	}

}
