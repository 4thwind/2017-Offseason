package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.TurretSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class TurnTurretCommand extends Command {
	TurretSubsystem turretSubsystem;

	public TurnTurretCommand() {
		turretSubsystem = ServiceLocator.get(TurretSubsystem.class);

	}

	@Override
	protected void execute() {
		turretSubsystem.turnAuto();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
