package org.usfirst.frc.team2175.properties;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.usfirst.frc.team2175.Info.ButtonInfo;
import org.usfirst.frc.team2175.identifiers.ButtonIDs;
import org.usfirst.frc.team2175.identifiers.FieldCheck;

public class JoystickProperties extends BaseProperties {
	private HashMap<String, ButtonInfo> buttonInfoMap;

	@Override
	protected void populate() {
		buttonInfoMap = new HashMap<>();
		ButtonIDs bIDs = new ButtonIDs();
		for (Field field : bIDs.getClass().getDeclaredFields()) {
			try {
				if (FieldCheck.areFieldRequirementsMet(field.toString())) {
					createInfoFromProps(field.get(bIDs).toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void createInfoFromProps(String id) {
		ButtonInfo info = new ButtonInfo(getString(id)[0], getInt(id, 1));
		buttonInfoMap.put(id, info);
	}

	@Override
	protected String getPropertyFileName() {
		return "joysticks.properties";
	}
}
