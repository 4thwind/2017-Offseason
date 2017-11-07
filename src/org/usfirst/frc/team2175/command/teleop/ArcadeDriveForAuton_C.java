package org.usfirst.frc.team2175.command.teleop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.command.Base_C;
import org.usfirst.frc.team2175.subsystem.Drivetrain_S;

public class ArcadeDriveForAuton_C extends Base_C {
	private final Drivetrain_S drivetrain_S;
	private final double move;
	private final double turn;

	public ArcadeDriveForAuton_C(double move, double turn) {
		drivetrain_S = ServiceLocator.get(Drivetrain_S.class);
		this.move = move;
		this.turn = turn;
	}

	public ArcadeDriveForAuton_C(double move) {
		this(move, 0);
	}

	@Override
	protected void initialize() {
		if (turn != 0) {
			drivetrain_S.arcadeDrive(move, turn);
		} else {
			drivetrain_S.straightArcadeDrive(move);
		}
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
