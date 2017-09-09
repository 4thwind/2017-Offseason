// package org.usfirst.frc.team2175.control;
//
// import java.lang.reflect.Field;
// import java.util.HashMap;
//
// import org.usfirst.frc.team2175.ServiceLocator;
// import org.usfirst.frc.team2175.identifiers.ButtonIDs;
// import org.usfirst.frc.team2175.identifiers.FieldCheck;
//
// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
//
// public class DriverStation {
// private HashMap<String, JoystickButton> buttonMap;
// // private JoystickProperties joystickProperties;
//
// private Joystick leftJoystick;
// private Joystick rightJoystick;
// private Joystick gamepad;
//
// public DriverStation() {
// // joystickProperties = ServiceLocator.get(JoystickProperties.class);
// leftJoystick = new Joystick(0);
// rightJoystick = new Joystick(0);
// gamepad = new Joystick(0);
//
// registerButtonsToMap();
//
// ServiceLocator.register(this);
// }
//
// private void registerButtonsToMap() {
// ButtonIDs bIDs = new ButtonIDs();
// for (Field field : bIDs.getClass().getDeclaredFields()) {
// try {
// if (FieldCheck.areFieldRequirementsMet(field.toString())) {
// createButtonFromInfo(field.get(bIDs).toString());
// }
// } catch (Exception e) {
// e.printStackTrace();
// }
// }
// }
//
// private void createButtonFromInfo(String id) {
// // ButtonInfo info = joystickProperties.getButtonInfo(id);
// JoystickButton button = new JoystickButton(
// joystickForName(info.joystickName), info.buttonNumber);
// buttonMap.put(id, button);
// }
//
// private Joystick joystickForName(final String name) {
// Joystick joystickOfChoice = null;
// switch (name) {
// case "left" :
// joystickOfChoice = leftJoystick;
// break;
// case "right" :
// joystickOfChoice = rightJoystick;
// break;
// case "gamepad" :
// joystickOfChoice = gamepad;
// break;
// default :
// final String msg = "Joystick name parameter is not valid. Joystick name is="
// + name;
// throw new IllegalArgumentException(msg);
// }
// return joystickOfChoice;
// }
//
// public JoystickButton getButton(String key) {
// return buttonMap.get(key);
//
// }
//
// public double getMoveValue() {
// return leftJoystick.getY();
// }
//
// public double getTurnValue() {
// return rightJoystick.getX();
// }
//
// public double getClimberSpinSpeed() {
// return gamepad.getRawAxis(1) * .1;
// }
//
// public double getOutput(final double input, final double deadbandSize) {
// double output = 0;
// if (Math.abs(input) >= deadbandSize) {
// double slope = 1 / (1 - deadbandSize);
// double sign = Math.signum(input);
// output = slope * sign * (Math.abs(input) - deadbandSize);
// }
// return output;
// }
// }
