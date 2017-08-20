package org.usfirst.frc.team2175.properties;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.usfirst.frc.team2175.Info.DigitalInfo;
import org.usfirst.frc.team2175.Info.EncoderInfo;
import org.usfirst.frc.team2175.Info.MotorInfo;
import org.usfirst.frc.team2175.Info.SolenoidInfo;
import org.usfirst.frc.team2175.identifiers.FieldCheck;
import org.usfirst.frc.team2175.identifiers.MotorIDs;
import org.usfirst.frc.team2175.identifiers.SolenoidIDs;

public class WiringProperties extends BaseProperties {
	private HashMap<String, MotorInfo> motorInfoMap;
	private HashMap<String, SolenoidInfo> solenoidInfoMap;

	private DigitalInfo switchOne;
	private DigitalInfo switchTwo;
	private EncoderInfo encoderInfo;

	@Override
	protected void populate() {
		motorInfoMap = new HashMap<>();
		MotorIDs mIDs = new MotorIDs();

		solenoidInfoMap = new HashMap<>();
		SolenoidIDs sIDs = new SolenoidIDs();

		for (Field field : mIDs.getClass().getDeclaredFields()) {
			try {
				if (FieldCheck.areFieldRequirementsMet(field.toString())) {
					createInfoFromProps(mIDs, field.get(mIDs).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (Field field : sIDs.getClass().getDeclaredFields()) {
			try {
				if (FieldCheck.areFieldRequirementsMet(field.toString())) {
					createInfoFromProps(sIDs, field.get(sIDs).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		switchOne = new DigitalInfo(0);
		switchTwo = new DigitalInfo(0);
		encoderInfo = new EncoderInfo(0, 0, false);
	}

	public MotorInfo getMotorInfo(String key) {
		return motorInfoMap.get(key);
	}

	public SolenoidInfo getSolenoidInfo(String key) {
		return solenoidInfoMap.get(key);
	}

	public DigitalInfo getSwitchOne() {
		return switchOne;
	}

	public DigitalInfo getSwitchTwo() {
		return switchTwo;
	}

	public EncoderInfo getEncoderInfo() {
		return encoderInfo;
	}

	private void createInfoFromProps(SolenoidIDs sIDs, String id) {
		int[] port;
		if (getString(id).length == 3) {
			int[] loc = {getInt(id, 1), getInt(id, 2)};
			port = loc;
		} else {
			int[] loc = {getInt(id, 1)};
			port = loc;
		}
		SolenoidInfo info = new SolenoidInfo(getString(id)[0], port);
		solenoidInfoMap.put(id, info);
	}

	private void createInfoFromProps(MotorIDs mIDs, final String id) {
		MotorInfo info = new MotorInfo(getInt(id, 0), getReversed(id));
		motorInfoMap.put(id, info);
	}

	@Override
	protected String getPropertyFileName() {
		return "wiring.properties";
	}

}
