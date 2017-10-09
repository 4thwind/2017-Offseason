package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Behavior_K;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;

public class Turret_S extends Base_S {
	private boolean impossibleEncoder;
	private double neededEncoderTicks;
	private double maxTurretSpeed;
	private DigitalInput sensor;
	private Encoder encoder;
	private CANTalon turret;
	private double offset;

	public Turret_S() {
		maxTurretSpeed = getSpeed(Behavior_K.TURRET_SPEED);

		turret = makeMotor(Wiring_K.TURRET);
		encoder = makeEncoder(Wiring_K.TURRET_ENCODER);
		sensor = makeDIO(Wiring_K.TURRET_DIO);

		impossibleEncoder = false;
	}

	public synchronized void allocate(double offset) {
		this.offset = offset;
	}

	public void turn(double speed) {
		turret.set(speed * maxTurretSpeed);
	}

	public void stop() {
		turret.set(0);
	}

	public boolean isSensorTriggered() {
		return sensor.get();
	}

	public boolean hitRightMagnet() {
		return isSensorTriggered() && encoder.getDistance() > 0;
	}

	public boolean hitLeftMagnet() {
		return isSensorTriggered() && encoder.getDistance() < 0;
	}

	public synchronized void turnViaEncoder() {
		// See if the sensor prevents us from reaching the position desired
		if ((Math.signum(offset) == Math.signum(encoder.getDistance()))
				&& isSensorTriggered()) {
			impossibleEncoder = true;
		} else {
			// Get encoder ticks and start turning
			encoder.reset();
			neededEncoderTicks = offsetToTicks();
		}
	}

	public synchronized void turnAuto() {
		turret.set(0.2 * Math.signum(offset));
	}

	private double offsetToTicks() {
		return offset * 1;
	}

	public synchronized boolean isEncoderCorrect() {
		if (impossibleEncoder) {
			impossibleEncoder = false;
			return true;
		} else {
			return Math.abs(encoder.getDistance()) > Math
					.abs(neededEncoderTicks);
		}
	}
}
