package org.usfirst.frc.team2175.subsystem;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

public class DrivetrainSubsystem extends BaseSubsystem {
	private CANTalon leftMasterMotor;
	private CANTalon leftSlaveMotorOne;
	private CANTalon leftSlaveMotorTwo;
	private CANTalon rightMasterMotor;
	private CANTalon rightSlaveMotorOne;
	private CANTalon rightSlaveMotorTwo;

	private Encoder encoder;
	private RobotDrive robotDrive;

	private DoubleSolenoid driveShifters;

	private AHRS navXGyro;

	public DrivetrainSubsystem() {
		leftMasterMotor = new CANTalon(0);
		leftSlaveMotorOne = new CANTalon(0);
		leftSlaveMotorTwo = new CANTalon(0);
		rightMasterMotor = new CANTalon(0);
		rightSlaveMotorOne = new CANTalon(0);
		rightSlaveMotorTwo = new CANTalon(0);

		setSlave(leftSlaveMotorOne, leftMasterMotor);
		setSlave(leftSlaveMotorTwo, leftMasterMotor);
		setSlave(rightSlaveMotorOne, rightMasterMotor);
		setSlave(rightSlaveMotorTwo, rightMasterMotor);

		driveShifters = new DoubleSolenoid(0, 0);

		robotDrive = new RobotDrive(leftMasterMotor, rightMasterMotor);
		navXGyro = new AHRS(SPI.Port.kMXP);
		encoder = new Encoder(0, 0);
	}

	private void setSlave(final CANTalon slave, final CANTalon master) {
		slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		slave.set(master.getDeviceID());
	}
}
