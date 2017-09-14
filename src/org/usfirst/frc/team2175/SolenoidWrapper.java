package org.usfirst.frc.team2175;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidWrapper {
	private DoubleSolenoid doubleSolenoid;
	private Solenoid solenoid;
	private boolean isDouble;

	public SolenoidWrapper(String info) {
		String[] data = info.split(",");
		if (data[0].contains("single")) {
			solenoid = new Solenoid(Integer.parseInt(data[1].trim()));
			isDouble = false;
		} else {
			doubleSolenoid = new DoubleSolenoid(
					Integer.parseInt(data[1].trim()),
					Integer.parseInt(data[2].trim()));
			isDouble = true;
		}
	}

	public void set(final boolean on) {
		if (isDouble) {
			if (on) {
				doubleSolenoid.set(Value.kForward);
			} else {
				doubleSolenoid.set(Value.kReverse);
			}
		} else {
			solenoid.set(on);
		}
	}

	public boolean get() {
		if (isDouble) {
			if (doubleSolenoid.get() == Value.kForward) {
				return true;
			} else {
				return false;
			}
		} else {
			return solenoid.get();
		}
	}
}
