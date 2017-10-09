package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class TurnTurret_DC extends Base_C {
	Turret_S turret_S;
	DriverStation driverStation;

	public TurnTurret_DC() {
		driverStation = get(DriverStation.class);
		turret_S = get(Turret_S.class);

		requires(turret_S);
	}

	@Override
	protected void execute() {
		double turretSpeed = driverStation.getTurretTurnSpeed();
		boolean isSensorTriggered = turret_S.isSensorTriggered();
		boolean goingRight = turretSpeed > 0 && turret_S.hitLeftMagnet();
		boolean goingLeft = turretSpeed < 0 && turret_S.hitRightMagnet();
		if (!isSensorTriggered || goingRight || goingLeft) {
			turret_S.turn(turretSpeed);
		} else {
			turret_S.turn(0);
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
