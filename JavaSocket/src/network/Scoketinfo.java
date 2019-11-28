package network;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Scoketinfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket theSocket;
		System.out.println("..");
		for (int i = 0; i < args.length; i++) {
			try {
				theSocket = new Socket(args[i], 80);
				System.out.println("Socket Info : " + theSocket);
				System.out.println("Local Host" + theSocket.getLocalPort() + "Port~");
				System.out.println(theSocket.getInetAddress() + "Host : " + theSocket.getPort() + "Port Connection");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.err.println(args[i] + "Host err Search");
				// e.printStackTrace();
			} catch (SocketException e) {
				System.err.println(args[i] + "Host err Connection");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("err");
				// e.printStackTrace();
			}

		}

	}

}
