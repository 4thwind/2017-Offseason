package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class TurnTurret_DC extends Base_C {
	Turret_S turret_S;
	DriverStation driverStation;

	public TurnTurret_DC() {
		turret_S = ServiceLocator.get(Turret_S.class);
		driverStation = ServiceLocator.get(DriverStation.class);

		requires(turret_S);
	}

	@Override
	protected void execute() {
		if (!turret_S.isSensorTriggered()) {
			if (turret_S.isAutoAim()) {
				turret_S.turnAuto();
			} else {
				turret_S.turnManual(driverStation.getTurretTurnSpeed());
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		turret_S.stop();
	}
}
