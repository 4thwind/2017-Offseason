package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

public class RunAgitation_C extends Base_C {
	Shooter_S shooter_S;
	private final double timeToWait;
	private double timeWaited;
	private double timeInitialized;
	private final boolean isAuton;

	public RunAgitation_C(double timeToWait, boolean isAuton) {
		this.timeToWait = timeToWait * 1000;
		timeWaited = 0;
		shooter_S = get(Shooter_S.class);
		this.isAuton = isAuton;
	}

	public RunAgitation_C(double timeToWait) {
		this(timeToWait, false);
	}

	public RunAgitation_C() {
		this(0.0);
	}

	@Override
	protected void initialize() {
		timeInitialized = System.currentTimeMillis();
	}

	@Override
	protected void execute() {
		double currTime = System.currentTimeMillis();
		timeWaited = currTime - timeInitialized;
		if (timeWaited >= timeToWait) {
			if ((shooter_S.isShooterSpinning() && !isAuton) || (isAuton)) {
				shooter_S
						.feed((currTime - timeToWait - timeInitialized) / 1000);
			}
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
