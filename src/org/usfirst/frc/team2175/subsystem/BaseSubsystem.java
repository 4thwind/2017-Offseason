package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BaseSubsystem extends Subsystem {
	public BaseSubsystem() {
		ServiceLocator.register(this);
	}

	@Override
	protected void initDefaultCommand() {
	}

}
