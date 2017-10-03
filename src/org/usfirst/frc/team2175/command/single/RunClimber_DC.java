package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.subsystem.Climber_S;

public class RunClimber_DC extends Base_C {
	private Climber_S climber_S;
	private DriverStation driverStation;

	public RunClimber_DC() {
		climber_S = ServiceLocator.get(Climber_S.class);
		driverStation = ServiceLocator.get(DriverStation.class);
	}

	@Override
	protected void initialize() {
		climber_S.setClimberSpeed(driverStation.getClimberSpinSpeed());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		climber_S.setClimberSpeed(0);
	}
}
