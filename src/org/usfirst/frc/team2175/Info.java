package org.usfirst.frc.team2175;

public class Info {
	public static class MotorInfo {
		public final int deviceNumber;
		public final boolean isInverted;

		public MotorInfo(final int deviceNumber, final boolean isInverted) {
			this.deviceNumber = deviceNumber;
			this.isInverted = isInverted;
		}
	}

	public static class SolenoidInfo {
		public final String type;
		public int[] ports = new int[2];

		public SolenoidInfo(final String type, final int[] ports) {
			this.type = type;
			this.ports = ports;
		}
	}

	public static class ButtonInfo {
		public final String joystickName;
		public final int buttonNumber;
		public ButtonInfo(final String joystickName, final int buttonNumber) {
			this.joystickName = joystickName;
			this.buttonNumber = buttonNumber;
		}
	}

	public static class BehaviorInfo {
		public final double inSpeed;
		public final double outSpeed;
		public BehaviorInfo(double inSpeed, double outSpeed) {
			this.inSpeed = inSpeed;
			this.outSpeed = outSpeed;
		}
	}

	public static class EncoderInfo {
		public final int sourceA;
		public final int sourceB;
		public final boolean isInverted;

		public EncoderInfo(final int sourceA, final int sourceB,
				final boolean isInverted) {
			this.sourceA = sourceA;
			this.sourceB = sourceB;
			this.isInverted = isInverted;
		}
	}

	public static class DigitalInfo {
		public final int channel;

		public DigitalInfo(int channel) {
			this.channel = channel;
		}
	}
}
