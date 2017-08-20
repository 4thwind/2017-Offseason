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
}
