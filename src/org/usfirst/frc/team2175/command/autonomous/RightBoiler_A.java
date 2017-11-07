package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.Base_CG;
import org.usfirst.frc.team2175.command.teleop.ArcadeDriveForAuton_C;
import org.usfirst.frc.team2175.command.teleop.RunAgitation_C;
import org.usfirst.frc.team2175.command.teleop.RunShooter_C;

public class RightBoiler_A extends Base_CG {
	private final double turnDistance = 0;
	private final double turnTime = 0;
	private final double moveDistance = 0;
	private final double moveTime = 1;

	public RightBoiler_A() {
		addParallel(new RunShooter_C(), 7);
		addSequential(new RunAgitation_C(2), 7);
		addSequential(new ArcadeDriveForAuton_C(0, turnDistance), turnTime);
		addSequential(new ArcadeDriveForAuton_C(moveDistance), moveTime);
	}
}
