package org.usfirst.frc.team2175;

import java.util.HashMap;

public class ServiceLocator {

	private static final HashMap<Class<?>, Object> MAP = new HashMap<>();

	public static void register(final Object instance) {
		MAP.put(instance.getClass(), instance);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(final Class<T> clazz) {
		return (T) MAP.get(clazz);
	}
}
