package org.usfirst.frc.team2175.command.single;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.BaseCommand;
import org.usfirst.frc.team2175.control.DriverStation;
import org.usfirst.frc.team2175.subsystem.DrivetrainSubsystem;

public class ArcadeDriveWithJoysticksCommand extends BaseCommand {
	DrivetrainSubsystem drivetrainSubsystem;
	DriverStation driverStation;

	public ArcadeDriveWithJoysticksCommand() {
		drivetrainSubsystem = ServiceLocator.get(DrivetrainSubsystem.class);
		driverStation = ServiceLocator.get(DriverStation.class);
	}
	@Override
	protected void execute() {
		double moveValue = driverStation.getMoveValue();
		double turnValue = driverStation.getTurnValue();
		drivetrainSubsystem.arcadeDrive(moveValue, turnValue);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		drivetrainSubsystem.stopAllMotors();
	}
}
