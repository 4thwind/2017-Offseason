package org.usfirst.frc.team2175.subsystem;

import org.usfirst.frc.team2175.Info.BehaviorInfo;
import org.usfirst.frc.team2175.Info.MotorInfo;
import org.usfirst.frc.team2175.Info.SolenoidInfo;
import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.properties.BehaviorProperties;
import org.usfirst.frc.team2175.properties.WiringProperties;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BaseSubsystem extends Subsystem {
	public BaseSubsystem() {
		ServiceLocator.register(this);
	}

	protected CANTalon motorFromInfoID(String key) {
		MotorInfo info = getMotorInfo(key);
		CANTalon talon = new CANTalon(info.deviceNumber);
		talon.reverseOutput(info.isInverted);
		return talon;
	}

	protected MotorInfo getMotorInfo(String key) {
		WiringProperties wiringProperties = ServiceLocator
				.get(WiringProperties.class);
		return wiringProperties.getMotorInfo(key);
	}

	protected BehaviorInfo getBehaviorInfo(String key) {
		BehaviorProperties behaviorProperties = ServiceLocator
				.get(BehaviorProperties.class);
		return behaviorProperties.getBehaviorInfo(key);
	}

	protected SolenoidInfo getSolenoidInfo(String key) {
		WiringProperties wiringProperties = ServiceLocator
				.get(WiringProperties.class);
		return wiringProperties.getSolenoidInfo(key);
	}

	public void setDefaultCommand(Command command) {
		super.setDefaultCommand(command);
	}

	@Override
	protected void initDefaultCommand() {
	}

}
