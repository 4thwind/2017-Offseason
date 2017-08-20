package org.usfirst.frc.team2175.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
	private static final String CAN_T_CONTINUE_MSG = "; can't continue";

	public Properties loadProperties(final String fileName) {
		final File file = new File(fileName);
		return loadProperties(file);
	}

	public Properties loadProperties(final File file) {
		final InputStream inputStream = openPropertiesFile(file);
		final Properties prop = loadPropertiesFromFile(file, inputStream);
		errorIfNoPropertiesLoaded(file, prop);

		return prop;
	}

	private InputStream openPropertiesFile(final File file) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
		} catch (final FileNotFoundException e) {
			final String msg = "Error finding properties file=" + file
					+ CAN_T_CONTINUE_MSG;
			throw new IllegalStateException(msg, e);
		}
		return inputStream;
	}

	private Properties loadPropertiesFromFile(final File file,
			final InputStream inputStream) {
		final Properties prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (final IOException e) {
			final String msg = "Error reading properties file=" + file
					+ CAN_T_CONTINUE_MSG;
			throw new IllegalStateException(msg, e);
		}
		return prop;
	}

	private void errorIfNoPropertiesLoaded(final File file,
			final Properties prop) {
		if (prop.isEmpty()) {
			final String msg = "No properties were loaded from file=" + file
					+ CAN_T_CONTINUE_MSG;
			throw new IllegalStateException(msg);
		}
	}
}
