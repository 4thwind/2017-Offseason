package org.usfirst.frc.team2175.identifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldCheck {

	public static boolean areFieldRequirementsMet(String string) {
		Pattern var = Pattern.compile("[^A-Za-z.]");
		Matcher m = var.matcher(string);
		return !m.find();
	}
}
