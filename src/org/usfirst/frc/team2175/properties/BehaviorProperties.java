package org.usfirst.frc.team2175.properties;

import java.lang.reflect.Field;
import java.util.HashMap;

import org.usfirst.frc.team2175.Info.BehaviorInfo;
import org.usfirst.frc.team2175.identifiers.BehaviorIDs;
import org.usfirst.frc.team2175.identifiers.FieldCheck;

public class BehaviorProperties extends BaseProperties {
	private HashMap<String, BehaviorInfo> behaviorInfoMap;
	@Override
	protected void populate() {
		behaviorInfoMap = new HashMap<>();
		BehaviorIDs bIDs = new BehaviorIDs();
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
		BehaviorInfo info = new BehaviorInfo(getDouble(id + ".in"),
				getDouble(id + ".out"));
		behaviorInfoMap.put(id, info);
	}

	public BehaviorInfo getBehaviorInfo(String key) {
		return behaviorInfoMap.get(key);
	}

	@Override
	protected String getPropertyFileName() {
		return "behavior.properties";
	}

}
