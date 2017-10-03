package org.usfirst.frc.team2175.vision;

import java.net.Socket;

public class VisionServer {

	private static VisionServer s_instance = null;
	private int m_port;
	AdbBridge adb = new AdbBridge();
	double lastMessageReceivedTime = 0;

	public static VisionServer getInstance() {
		if (s_instance == null) {
			s_instance = new VisionServer(8254);
		}
		return s_instance;
	}

	private boolean mIsConnect = false;

	public boolean isConnected() {
		return mIsConnect;
	}

	protected class ServerThread {
		private Socket m_socket;

		public ServerThread(Socket socket) {
			m_socket = socket;
		}

		public boolean isAlive() {
			return m_socket != null && m_socket.isConnected()
					&& !m_socket.isClosed();
		}

	}

	private VisionServer(int port) {
		adb = new AdbBridge();
		m_port = port;
		adb.start();
		adb.reversePortForward(port, port);
		new Thread().start();
	}

	public void restartAdb() {
		adb.restartAdb();
		adb.reversePortForward(m_port, m_port);
	}
}
