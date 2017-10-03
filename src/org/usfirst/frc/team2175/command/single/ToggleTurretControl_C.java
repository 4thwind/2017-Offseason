package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class ToggleTurretControl_C extends Base_C {
	private Turret_S turret_S;

	public ToggleTurretControl_C() {
		turret_S = ServiceLocator.get(Turret_S.class);
	}

	@Override
	protected void initialize() {
		turret_S.toggleAuto();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		turret_S.toggleAuto();
	}

}
