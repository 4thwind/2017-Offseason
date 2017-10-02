package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.BallIntake_S;

public class RunBallIntakeIn_C extends Base_C {
	private BallIntake_S ballIntake_S;

	public RunBallIntakeIn_C() {
		ballIntake_S = ServiceLocator.get(BallIntake_S.class);
	}

	@Override
	protected void initialize() {
		ballIntake_S.runIn();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		ballIntake_S.stop();
	}
}
