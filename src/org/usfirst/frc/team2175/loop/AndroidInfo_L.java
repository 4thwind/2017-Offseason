package org.usfirst.frc.team2175.loop;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import org.usfirst.frc.team2175.ServiceLocator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AndroidInfo_L extends Control_L {

	DatagramSocket datagramSocket;
	AdbBridge bridge;

	// Must only be run in robot init
	public AndroidInfo_L() {
		bridge = new AdbBridge();

		bridge.start();

		bridge.portForward(5806, 5806);
		try {
			datagramSocket = new DatagramSocket(5806);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		ServiceLocator.register(this);
	}

	@Override
	protected long getPeriodMs() {
		return 10;
	}

	@Override
	protected void runTask() {
		double offset = Math.pow(2175.0, 3);
		String message = "";
		try {
			byte[] receiveData = new byte[1024];

			DatagramPacket datagramPacket = new DatagramPacket(receiveData,
					receiveData.length);

			datagramSocket.receive(datagramPacket);
			System.out.println("Datagram Packet Received");

			message = new String(datagramPacket.getData());
			System.out.println(message);
			// offset = Double.parseDouble(message);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		SmartDashboard.putString("dank", message);
	}
}
