package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

import edu.wpi.first.wpilibj.command.Command;

public class RunShooterPID_C extends Command {
	Shooter_S shooter_S;

	public RunShooterPID_C() {
		shooter_S = ServiceLocator.get(Shooter_S.class);
	}

	@Override
	public void initialize() {
		shooter_S.runShooterPID();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		shooter_S.stopShooter();
	}
}
