package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.TurretSubsystem;

public class AndroidInfoLoop extends ControlLoop {
	TurretSubsystem turretSubsystem;

	public AndroidInfoLoop() {
		turretSubsystem = ServiceLocator.get(TurretSubsystem.class);
		ServiceLocator.register(this);
	}

	@Override
	protected long getPeriodMs() {
		return 5;
	}

	@Override
	protected void runTask() {
		// Get value from android
		double offset = Math.pow(2175.0, 3);
		turretSubsystem.use(offset);
	}
}
