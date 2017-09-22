package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

import edu.wpi.first.wpilibj.command.Command;

public class RunAgitator_C extends Command {
	Shooter_S shooterSubsystem;

	public RunAgitator_C() {
		shooterSubsystem = ServiceLocator.get(Shooter_S.class);
	}

	@Override
	protected void initialize() {
		shooterSubsystem.runAgitator();
	}

	@Override
	protected boolean isFinished() {
		return !shooterSubsystem.isShooterSpinning();
	}

	@Override
	protected void end() {
		shooterSubsystem.stopAgitator();
	}

}
