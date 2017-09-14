package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.identifiers.WiringKeys;
import org.usfirst.frc.team2175.info.InfoLocator;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;

public class DrivetrainSubsystem extends BaseSubsystem {
	private InfoLocator infoLocator;
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

	public DrivetrainSubsystem() {
		infoLocator = ServiceLocator.get(InfoLocator.class);

		leftMaster = makeMotor(WiringKeys.LEFT_MASTER);
		leftSlaveOne = makeMotor(WiringKeys.LEFT_SLAVEONE);
		leftSlaveTwo = makeMotor(WiringKeys.LEFT_SLAVETWO);
		rightMaster = makeMotor(WiringKeys.RIGHT_MASTER);
		rightSlaveOne = makeMotor(WiringKeys.RIGHT_SLAVEONE);
		rightSlaveTwo = makeMotor(WiringKeys.RIGHT_SLAVETWO);

		setSlave(leftSlaveOne, leftMaster);
		setSlave(leftSlaveTwo, leftMaster);
		setSlave(rightSlaveOne, rightMaster);
		setSlave(rightSlaveTwo, rightMaster);

		robotDrive = new RobotDrive(leftMaster, rightMaster);

		navXGyro = new AHRS(SPI.Port.kMXP);
		encoder = new Encoder(0, 0);
		encoder.setDistancePerPulse(1);
	}

	private CANTalon makeMotor(String info) {
		String[] infos = infoLocator.getWiringInfo(info).split(",");
		CANTalon motor = new CANTalon(Integer.parseInt(infos[0].trim()));
		motor.reverseOutput(infos[1].trim() == "true");
		return motor;
	}

	private void setSlave(final CANTalon slave, final CANTalon master) {
		slave.changeControlMode(CANTalon.TalonControlMode.Follower);
		slave.set(master.getDeviceID());
	}

	private void setGear(final boolean forward) {
		driveShifters.set(forward);
	}

	public void shiftToHighGear() {
		setGear(true);
	}

	public void shiftToLowGear() {
		setGear(false);
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
}
