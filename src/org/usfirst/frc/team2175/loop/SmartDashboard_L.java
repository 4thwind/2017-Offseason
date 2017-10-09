package org.usfirst.frc.team2175.loop;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Shooter_S;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SmartDashboard_L extends Control_L {

	private SendableChooser<Command> autonSelector;

	public SmartDashboard_L() {
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
		showInfo();
	}

	private void showInfo() {
		SmartDashboard.putNumber("Shooter Speed",
				ServiceLocator.get(Shooter_S.class).getRpm());
	}

	public Command getAuton() {
		return autonSelector.getSelected();
	}

	public void makeAutonSelector() {
		populateAutonSelector();

		SmartDashboard.putData("Auton", autonSelector);
	}

}
