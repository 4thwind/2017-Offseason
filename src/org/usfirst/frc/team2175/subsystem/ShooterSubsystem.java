package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.SolenoidWrapper;
import org.usfirst.frc.team2175.TunedMotor;
import org.usfirst.frc.team2175.identifiers.BehaviorIDs;
import org.usfirst.frc.team2175.identifiers.MotorIDs;
import org.usfirst.frc.team2175.identifiers.SolenoidIDs;

public class ShooterSubsystem extends BaseSubsystem {
	private SolenoidWrapper angleSolenoid;

	private TunedMotor shooter;
	private TunedMotor feeder;
	private TunedMotor agitator;

	public ShooterSubsystem() {
		angleSolenoid = new SolenoidWrapper(
				getSolenoidInfo(SolenoidIDs.SHOOTER_ACTUATOR));

		shooter = new TunedMotor(getMotorInfo(MotorIDs.SHOOTER),
				getBehaviorInfo(BehaviorIDs.SHOOTER));
		feeder = new TunedMotor(getMotorInfo(MotorIDs.FEEDER),
				getBehaviorInfo(BehaviorIDs.FEEDER));
		agitator = new TunedMotor(getMotorInfo(MotorIDs.AGITATOR),
				getBehaviorInfo(BehaviorIDs.AGITATOR));
	}

	public void spinShooterOut() {
		shooter.spinOut();
	}

	public void spinShooterIn() {
		shooter.spinIn();
	}

	public void spinFeederOut() {
		feeder.spinOut();
	}

	public void spinFeederIn() {
		feeder.spinIn();
	}

	public void spinAgitatorOut() {
		agitator.spinOut();
	}

	public void spinAgitatorIn() {
		agitator.spinIn();
	}

	public void moreAngle() {
		angleSolenoid.set(false);
	}

	public void lessAngle() {
		angleSolenoid.set(true);
	}

	public void toggleAngle() {
		angleSolenoid.set(!angleSolenoid.get());
	}

	public boolean isShooterRunning() {
		return shooter.isRunning();
	}

	public void stopFeeder() {
		feeder.stop();
	}

	public void stopAgitator() {
		agitator.stop();
	}

	public void stopShooter() {
		shooter.stop();
	}
}
