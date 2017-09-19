package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.loop.AndroidInfoLoop;
import org.usfirst.frc.team2175.subsystem.TurretSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnTurretCommand extends Command {
	TurretSubsystem turretSubsystem;
	AndroidInfoLoop androidInfoLoop;
	DriverStation driverStation;

	public TurnTurretCommand() {
		turretSubsystem = ServiceLocator.get(TurretSubsystem.class);
		androidInfoLoop = ServiceLocator.get(AndroidInfoLoop.class);
		driverStation = ServiceLocator.get(DriverStation.class);

	}

	@Override
	protected void execute() {
		if (turretSubsystem.isTargetVisible()) {
			turretSubsystem.turnAuto();
		} else {
			turretSubsystem.turn(driverStation.getTurretTurnSpeed());
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
