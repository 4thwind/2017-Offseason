package org.usfirst.frc.team2175.loop;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

import org.usfirst.frc.team2175.ServiceLocator;
import org.usfirst.frc.team2175.subsystem.Turret_S;

public class AndroidInfo_L extends Control_L {
	Turret_S turretSubsystem;

	DatagramSocket datagramSocket;

	// Must only be run in robot init
	public AndroidInfo_L() {
		turretSubsystem = ServiceLocator.get(Turret_S.class);

		setupADB();

		try {
			datagramSocket = new DatagramSocket(5806);
		} catch (SocketException e) {
			e.printStackTrace();
		}

		ServiceLocator.register(this);
	}

	private void setupADB() {
		try {
			Process p = Runtime.getRuntime()
					.exec("adb forward tcp:5806 tcp:5806");
			Scanner sc = new Scanner(p.getErrorStream());
			if (sc.hasNext()) {
				while (sc.hasNext())
					System.out.println(sc.next());
				System.out.println("Cannot start the Android debug bridge");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	@Override
	protected long getPeriodMs() {
		return 10;
	}

	@Override
	protected void runTask() {
		double offset = Math.pow(2175.0, 3);
		try {
			byte[] receiveData = new byte[1024];

			DatagramPacket datagramPacket = new DatagramPacket(receiveData,
					receiveData.length);

			datagramSocket.receive(datagramPacket);
			System.out.println("Datagram Packet Received");

			String message = new String(datagramPacket.getData());
			System.out.println(message);
			offset = Double.parseDouble(message);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		turretSubsystem.use(offset);
	}
}
