package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drivetrain_S extends Base_S {
	private CANTalon leftMaster;
	private CANTalon leftSlaveOne;
	private CANTalon leftSlaveTwo;
	private CANTalon rightMaster;
	private CANTalon rightSlaveOne;
	private CANTalon rightSlaveTwo;

	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private RobotDrive robotDrive;

	private DoubleSolenoid driveShifters;

	private AHRS navXGyro;

	public Drivetrain_S() {
		leftMaster = makeMotor(Wiring_K.LEFT_MASTER);
		leftSlaveOne = makeMotor(Wiring_K.LEFT_SLAVEONE);
		leftSlaveTwo = makeMotor(Wiring_K.LEFT_SLAVETWO);
		rightMaster = makeMotor(Wiring_K.RIGHT_MASTER);
		rightSlaveOne = makeMotor(Wiring_K.RIGHT_SLAVEONE);
		rightSlaveTwo = makeMotor(Wiring_K.RIGHT_SLAVETWO);

		driveShifters = new DoubleSolenoid(1, 2);

		setSlave(leftSlaveOne, leftMaster);
		setSlave(leftSlaveTwo, leftMaster);
		setSlave(rightSlaveOne, rightMaster);
		setSlave(rightSlaveTwo, rightMaster);

		robotDrive = new RobotDrive(leftMaster, rightMaster);

		// navXGyro = new AHRS(SPI.Port.kMXP);
		leftEncoder = new Encoder(1, 2);
		leftEncoder.setDistancePerPulse(1);

		rightEncoder = new Encoder(3, 4);
		rightEncoder.setDistancePerPulse(1);
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
		arcadeDrive(moveValue, -navXGyro.getAngle() / 45);
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public void resetGyro() {
		navXGyro.reset();
	}

	public int getEncoderDistance() {
		return (leftEncoder.get() + rightEncoder.get()) / 2;
	}

	public double convertFromInchesToClicks(double inchesToDrive) {
		return inchesToDrive * 40.21;
	}

	public void resetSensors() {
		resetEncoders();
		resetGyro();
	}
}
