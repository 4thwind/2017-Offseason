package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.identifiers.BehaviorKeys;
import org.usfirst.frc.team2175.identifiers.WiringKeys;

import com.ctre.CANTalon;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;

public class GearIntakeSubsystem extends BaseSubsystem {
	private CANTalon gearMotor;
	private SolenoidWrapper actuator;
	private UsbCamera camera;

	private double gearIntakeInSpeed;
	private double gearIntakeOutSpeed;

	public GearIntakeSubsystem() {
		setUpCamera();

		gearMotor = makeMotor(WiringKeys.GEAR_INTAKE);
		actuator = new SolenoidWrapper(WiringKeys.GEAR_ACTUATOR);

		gearIntakeInSpeed = getSpeed(BehaviorKeys.GEAR_IN_SPEED);
		gearIntakeOutSpeed = getSpeed(BehaviorKeys.GEAR_OUT_SPEED);
	}

	private void setUpCamera() {
		camera = new UsbCamera("GearCam", 0);
		CameraServer.getInstance().startAutomaticCapture(camera);
		camera.setExposureManual(3);
	}

	public void spinIn() {
		gearMotor.set(gearIntakeInSpeed);
	}

	public void spinOut() {
		gearMotor.set(gearIntakeOutSpeed);
	}

	public void stop() {
		gearMotor.set(0);
	}

	public void toggleActuation() {
		actuator.set(!actuator.get());
	}

	public void raise() {
		actuator.set(true);
	}

	public void lower() {
		actuator.set(false);
	}

	public double getMotorCurrent() {
		return gearMotor.getOutputCurrent();
	}

	public boolean getIsGearIntakeOut() {
		return actuator.get();
	}

	public boolean isGearSolidlyInPlace() {
		return getMotorCurrent() > 40;
	}
}
