package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

public class Drivetrain_S extends Base_S {
	private CANTalon leftMaster;
	private CANTalon leftSlaveOne;
	private CANTalon leftSlaveTwo;
	private CANTalon rightMaster;
	private CANTalon rightSlaveOne;
	private CANTalon rightSlaveTwo;
	private RobotDrive robotDrive;

	private DoubleSolenoid driveShifters;

	private Encoder leftEncoder;
	private Encoder rightEncoder;

	private AHRS navXGyro;

	public Drivetrain_S() {
		leftMaster = makeMotor(Wiring_K.LEFT_MASTER);
		leftSlaveOne = makeMotor(Wiring_K.LEFT_SLAVEONE);
		leftSlaveTwo = makeMotor(Wiring_K.LEFT_SLAVETWO);
		rightMaster = makeMotor(Wiring_K.RIGHT_MASTER);
		rightSlaveOne = makeMotor(Wiring_K.RIGHT_SLAVEONE);
		rightSlaveTwo = makeMotor(Wiring_K.RIGHT_SLAVETWO);

		setSlave(leftSlaveOne, leftMaster);
		setSlave(leftSlaveTwo, leftMaster);
		setSlave(rightSlaveOne, rightMaster);
		setSlave(rightSlaveTwo, rightMaster);

		robotDrive = new RobotDrive(leftMaster, rightMaster);

		driveShifters = makeSolenoid(Wiring_K.DRIVE_SHIFTERS);

		navXGyro = new AHRS(SPI.Port.kMXP);
		leftEncoder = makeEncoder(Wiring_K.LEFT_ENCODER);
		rightEncoder = makeEncoder(Wiring_K.RIGHT_ENCODER);
	}

	public void shiftToHighGear() {
		driveShifters.set(Value.kForward);
	}

	public void shiftToLowGear() {
		driveShifters.set(Value.kReverse);
	}

	public void stopAllMotors() {
		leftMaster.set(0);
		rightMaster.set(0);
	}

	public void arcadeDrive(double moveValue, double turnValue) {
		robotDrive.arcadeDrive(moveValue, turnValue);
	}

	public void straightArcadeDrive(double moveValue) {
		arcadeDrive(moveValue, getAngle() / 45);
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public void resetGyro() {
		navXGyro.reset();
	}

	public void resetSensors() {
		resetEncoders();
		resetGyro();
	}

	public double getAngle() {
		return navXGyro.getAngle();
	}

	public double inchesToTicks(double inchesToDrive) {
		return inchesToDrive * 40.21;
	}

	public double getLeftEncoder() {
		return leftEncoder.getDistance();
	}

	public double getRightEncoder() {
		return rightEncoder.getDistance();
	}
}