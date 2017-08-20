package org.usfirst.frc.team2175.properties;

import java.util.Properties;

import org.usfirst.frc.team2175.ServiceLocator;

public abstract class BaseProperties {
	private static final String PROPERTY_FILE_DIR_DEFAULT = "/home/lvuser/";
	private static String propertyFileDir = PROPERTY_FILE_DIR_DEFAULT;
	private final Properties properties;

	public BaseProperties() {
		final String propertyFileName = getFullyQualifiedPropertyFileName();
		properties = new PropertiesLoader().loadProperties(propertyFileName);
		try {
			populate();
		} catch (final Throwable e) {
			throw e;
		}

		ServiceLocator.register(this);
	}

	protected abstract String getPropertyFileName();

	protected abstract void populate();

	protected boolean getBooleanPropertyValue(final String propertyName) {
		final String propertyValue = getStringPropertyValue(propertyName);
		return Boolean.parseBoolean(propertyValue);
	}

	protected int getIntPropertyValue(final String propertyName) {
		final String propertyValue = getStringPropertyValue(propertyName);
		return Integer.parseInt(propertyValue);
	}

	protected double getDoublePropertyValue(final String propertyName) {
		final String propertyValue = getStringPropertyValue(propertyName);
		return Double.parseDouble(propertyValue);
	}

	protected String getStringPropertyValue(final String propertyName) {
		final String value = properties.getProperty(propertyName);
		if (value == null) {
			final String msg = "Property '" + propertyName
					+ "' not found in property file";
			throw new IllegalStateException(msg);
		}
		return value;
	}

	protected int[] getIntArrayPropertyValue(final String propertyName) {
		final String[] returnValues = getStringArrayPropertyValue(propertyName);
		final int[] intValues = new int[returnValues.length];
		for (int i = 0; i < returnValues.length; i++) {
			intValues[i] = Integer.parseInt(returnValues[i]);
		}
		return intValues;
	}

	protected String[] getStringArrayPropertyValue(final String propertyName) {
		final String propertyValue = getStringPropertyValue(propertyName);
		String rawValues = propertyValue;
		rawValues = rawValues.replace("[", "");
		rawValues = rawValues.replace("]", "");
		final String[] splitValues = rawValues.split(",");
		final String[] returnValues = new String[splitValues.length];
		for (int i = 0; i < splitValues.length; i++) {
			returnValues[i] = splitValues[i].trim();
		}
		return returnValues;
	}

	public String getFullyQualifiedPropertyFileName() {
		return propertyFileDir + getPropertyFileName();
	}

	public static void setPropertyFileDir(final String directory) {
		propertyFileDir = directory;
	}

	public Properties getProperties() {
		return properties;
	}
}