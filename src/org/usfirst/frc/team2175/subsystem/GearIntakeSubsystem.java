package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.TunedMotor;
import org.usfirst.frc.team2175.identifiers.BehaviorIDs;
import org.usfirst.frc.team2175.identifiers.MotorIDs;
import org.usfirst.frc.team2175.identifiers.SolenoidIDs;

public class GearIntakeSubsystem extends BaseSubsystem {
	private SolenoidWrapper actuator;
	private TunedMotor motor;

	public GearIntakeSubsystem() {
		motor = new TunedMotor(getMotorInfo(MotorIDs.GEAR_INTAKE),
				getBehaviorInfo(BehaviorIDs.GEAR_INTAKE));

		actuator = new SolenoidWrapper(
				getSolenoidInfo(SolenoidIDs.GEAR_INTAKE));
	}

	public void runIn() {
		motor.spinIn();
	}

	public void runOut() {
		motor.spinOut();
	}

	public void stop() {
		motor.stop();
	}

	public void raise() {
		actuator.set(false);
	}

	public void lower() {
		actuator.set(true);
	}

	public void toggleActuation() {
		actuator.set(!actuator.get());
	}
}
