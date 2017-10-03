package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;

public class ArcadeDriveWithJoysticks_DC extends Base_C {
	Drivetrain_S drivetrain_S;
	DriverStation driverStation;

	public ArcadeDriveWithJoysticks_DC() {
		drivetrain_S = ServiceLocator.get(Drivetrain_S.class);
		driverStation = ServiceLocator.get(DriverStation.class);
	}

	@Override
	protected void execute() {
		double moveValue = driverStation.getMoveValue();
		double turnValue = driverStation.getTurnValue();
		drivetrain_S.arcadeDrive(moveValue, turnValue);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrain_S.stopAllMotors();
	}
}
