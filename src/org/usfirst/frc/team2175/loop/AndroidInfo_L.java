package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class AndroidInfo_L extends Control_L {
	Turret_S turretSubsystem;

	public AndroidInfo_L() {
		turretSubsystem = ServiceLocator.get(Turret_S.class);
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
