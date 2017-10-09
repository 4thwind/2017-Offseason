package org.usfirst.frc.team2175.command;

import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.first.wpilibj.command.Command;

public abstract class Base_C extends Command {

	public <T> T get(Class<T> clazz) {
		return ServiceLocator.get(clazz);
	}
	@Override
	protected void interrupted() {
		end();
	}

}
