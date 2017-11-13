package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

public class Climber_S extends Base_S {
	private final double maxClimberSpeed;
	private CANTalon climber;

	public Climber_S() {
		climber = makeMotor(Wiring_K.CLIMBER);

		maxClimberSpeed = getSpeed(Behavior_K.CLIMBER_MAX_SPEED);
	}

	public void setClimberSpeed(double speed) {
		climber.set((speed > 0) ? speed * maxClimberSpeed : 0);
	}
}