package org.usfirst.frc.team2175.command.autonomous;

import org.usfirst.frc.team2175.command.Base_CG;
import org.usfirst.frc.team2175.command.single.DriveInchesSimple_C;

public class RightBoiler_A extends Base_CG {

	public RightBoiler_A() {
		addSequential(new DriveInchesSimple_C());
		// addSequential(new)
	}
}
