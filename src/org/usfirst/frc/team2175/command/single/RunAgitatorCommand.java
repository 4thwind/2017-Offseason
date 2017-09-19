package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunAgitatorCommand extends Command {
	ShooterSubsystem shooterSubsystem;

	public RunAgitatorCommand() {
		shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
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
