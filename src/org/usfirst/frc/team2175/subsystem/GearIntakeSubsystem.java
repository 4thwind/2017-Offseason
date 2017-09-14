package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.info.InfoLocator;

import com.ctre.CANTalon;

public class GearIntakeSubsystem extends BaseSubsystem {
	private InfoLocator locator;

	private CANTalon intakeMotor;
	private SolenoidWrapper gearIntakeActuator;

	private double gearIntakeInSpeed;
	private double gearIntakeOutSpeed;

	public GearIntakeSubsystem() {
		locator = ServiceLocator.get(InfoLocator.class);

		// intakeMotor = motorFromInfo(
		// locator.getWiringInfo(WiringKeys.GEAR_INTAKE));
		// gearIntakeActuator = new SolenoidWrapper(
		// locator.getWiringInfo(WiringKeys.a));
		//
		// gearIntakeInSpeed = behaviorProperties.getGearIntakeInSpeed();
		// gearIntakeOutSpeed = behaviorProperties.getGearIntakeOutSpeed();
	}

	public void runIn() {
		intakeMotor.set(-gearIntakeInSpeed);
	}

	public void runOut() {
		intakeMotor.set(gearIntakeOutSpeed);
	}

	public void raiseIntake() {
		gearIntakeActuator.set(false);
	}

	public void lowerIntake() {
		gearIntakeActuator.set(true);
	}

	public void stop() {
		intakeMotor.set(0);
	}

	public void toggleActuation() {
		gearIntakeActuator.set(!gearIntakeActuator.get());
	}

	public void lower() {
		gearIntakeActuator.set(true);
	}

	public void raise() {
		gearIntakeActuator.set(false);
	}

	public double getMotorCurrent() {
		return intakeMotor.getOutputCurrent();
	}

	public boolean getIsGearIntakeOut() {
		return gearIntakeActuator.get();
	}

	public boolean isGearSolidlyInPlace() {
		return getMotorCurrent() > 40;
	}
}
