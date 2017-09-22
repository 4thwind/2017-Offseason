package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

import edu.wpi.first.wpilibj.command.Command;

public class RunShooterPID_C extends Command {
	Shooter_S shooterSubsystem;

	public RunShooterPID_C() {
		shooterSubsystem = ServiceLocator.get(Shooter_S.class);
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
