package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.keys.Wiring_K;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

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

	private Encoder encoder;
	private RobotDrive robotDrive;

	private SolenoidWrapper driveShifters;

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

		navXGyro = new AHRS(SPI.Port.kMXP);
		encoder = new Encoder(0, 0);
		encoder.setDistancePerPulse(1);
	}

	private void setSlave(final CANTalon slave, final CANTalon master) {
		slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		slave.set(master.getDeviceID());
	}

	public void shiftToHighGear() {
		driveShifters.set(true);
	}

	public void shiftToLowGear() {
		driveShifters.set(false);
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
		encoder.reset();
	}

	public void resetGyro() {
		navXGyro.reset();
	}

	public boolean isCurrentGreatEnough() {
		return leftMaster.getOutputCurrent() > 30;
	}

	public int getEncoderDistance() {
		return encoder.get();
	}

	public double convertFromInchesToClicks(double inchesToDrive) {
		return inchesToDrive * 40.21;
	}

	public void resetSensors() {
		resetEncoders();
		resetGyro();
	}
}
