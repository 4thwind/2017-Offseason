package org.usfirst.frc.team2175.subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class GearIntakeSubsystem extends BaseSubsystem {
	private CANTalon motor;
	private DoubleSolenoid actuator;

	private double inSpeed;
	private double outSpeed;

	public GearIntakeSubsystem() {
		motor = new CANTalon(7);
		motor.reverseOutput(true);
		actuator = new DoubleSolenoid(3, 4);

		inSpeed = 1;
		outSpeed = -1;
	}

	public void runIn() {
		motor.set(inSpeed);
	}

	public void runOut() {
		motor.set(outSpeed);
	}

	public void raise() {
		actuator.set(Value.kReverse);
	}

	public void lower() {
		actuator.set(Value.kForward);
	}

	public void stop() {
		motor.set(0);
	}

	public void toggleActuation() {
		if (actuator.get() == Value.kForward) {
			raise();
		} else {
			lower();
		}
	}
}
