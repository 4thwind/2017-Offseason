package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboardLoop extends ControlLoop {

	private SendableChooser<Command> autonSelector;

	public SmartDashboardLoop() {
		autonSelector = new SendableChooser<>();

		makeAutonSelector();

		ServiceLocator.register(this);
	}

	@Override
	protected long getPeriodMs() {
		return 10;
	}

	private void populateAutonSelector() {
	}

	@Override
	protected void runTask() {
	}

	public Command getAuton() {
		return autonSelector.getSelected();
	}

	public void makeAutonSelector() {
		populateAutonSelector();

		SmartDashboard.putData("Auton", autonSelector);
	}

}
