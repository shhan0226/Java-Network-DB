package server;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatHandler implements Runnable {
	private Socket socket;
	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private Thread listener;
	private static Vector handlers = new Vector();

	public ChatHandler(Socket socket) {
		this.socket = socket;
	}

	synchronized public void start() {
		if (listener == null) {
			try {
				dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
				listener = new Thread(this);
				listener.start();
			} catch (IOException e) {
			}
		}
	}

	synchronized public void stop() {
		if (listener != null) {
			try {
				if (listener != Thread.currentThread()) {
					listener.interrupt();
					listener = null;
					dataOut.close();
				}
			} catch (IOException e) {
			}
		}
	}

	public void run() {
		try {
			handlers.addElement(this);
			while (!Thread.interrupted()) {
				String message = dataIn.readUTF();
				broadcast(message);
				// test
				System.out.println(message);
			}
		} catch (EOFException e) {
		} catch (IOException ex) {
			if (listener == Thread.currentThread())
				ex.printStackTrace();
		} finally {
			handlers.removeElement(this);
		}
		stop();
	}

	private void broadcast(String message) {
		synchronized (handlers) {
			Enumeration enu = handlers.elements();
			while (enu.hasMoreElements()) {
				ChatHandler handler = (ChatHandler) enu.nextElement();
				try {
					handler.dataOut.writeUTF(message);
					handler.dataOut.flush();
				} catch (IOException e) {
					handler.stop();
				}
			}
		}
	}
}
