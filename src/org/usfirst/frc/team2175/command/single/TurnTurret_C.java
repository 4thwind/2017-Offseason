package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Turret_S;

import edu.wpi.first.wpilibj.command.Command;

public class TurnTurret_C extends Command {
	Turret_S turretSubsystem;

	public TurnTurret_C() {
		turretSubsystem = ServiceLocator.get(Turret_S.class);

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
