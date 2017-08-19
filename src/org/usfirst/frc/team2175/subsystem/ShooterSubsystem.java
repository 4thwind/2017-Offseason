package org.usfirst.frc.team2175.subsystem;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public class ShooterSubsystem extends BaseSubsystem {
	private DoubleSolenoid angleSolenoid;

	private CANTalon shooter;
	private double shooterSpeed;
	private double shooterReverseSpeed;

	private CANTalon feeder;
	private double feederSpeed;
	private double feederReverseSpeed;

	private CANTalon agitator;
	private double agitatorSpeed;
	private double agitatorReverseSpeed;

	public ShooterSubsystem() {
		angleSolenoid = new DoubleSolenoid(0, 0);

		shooter = new CANTalon(0);
		shooterSpeed = 1;
		shooterReverseSpeed = -1;

		feeder = new CANTalon(0);
		feederSpeed = 1;
		feederReverseSpeed = -1;

		agitator = new CANTalon(0);
		agitatorSpeed = 1;
		agitatorReverseSpeed = -1;
	}
}
