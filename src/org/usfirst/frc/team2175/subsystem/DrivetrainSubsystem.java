package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.identifiers.MotorIDs;
import org.usfirst.frc.team2175.identifiers.SolenoidIDs;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

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

	private SolenoidWrapper driveShifters;

	private AHRS navXGyro;

	public DrivetrainSubsystem() {
		leftMasterMotor = motorFromInfoID(MotorIDs.LEFT_MASTER);
		leftSlaveMotorOne = motorFromInfoID(MotorIDs.LEFT_SLAVEONE);
		leftSlaveMotorTwo = motorFromInfoID(MotorIDs.LEFT_SLAVETWO);
		rightMasterMotor = motorFromInfoID(MotorIDs.RIGHT_MASTER);
		rightSlaveMotorOne = motorFromInfoID(MotorIDs.RIGHT_SLAVEONE);
		rightSlaveMotorTwo = motorFromInfoID(MotorIDs.RIGHT_SLAVETWO);

		setSlave(leftSlaveMotorOne, leftMasterMotor);
		setSlave(leftSlaveMotorTwo, leftMasterMotor);
		setSlave(rightSlaveMotorOne, rightMasterMotor);
		setSlave(rightSlaveMotorTwo, rightMasterMotor);

		robotDrive = new RobotDrive(leftMasterMotor, rightMasterMotor);

		driveShifters = new SolenoidWrapper(
				getSolenoidInfo(SolenoidIDs.DRIVE_SHIFTERS));

		navXGyro = new AHRS(SPI.Port.kMXP);
		encoder = new Encoder(0, 0);
	}

	private void setSlave(final CANTalon slave, final CANTalon master) {
		slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		slave.set(master.getDeviceID());
	}
}
