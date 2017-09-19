package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.ShooterSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public class RunShooterPIDCommand extends Command {
	ShooterSubsystem shooterSubsystem;

	public RunShooterPIDCommand() {
		shooterSubsystem = ServiceLocator.get(ShooterSubsystem.class);
	}

	@Override
	public void initialize() {
		shooterSubsystem.runShooterPID();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		shooterSubsystem.stopShooter();
	}
}
