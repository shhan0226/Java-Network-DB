package network;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketCon {

	public static void main(String args[]) {
		ServerSocket theServer = null;
		int port;

		if (args.length == 1) {
			port = Integer.parseInt(args[0]);
		} else {
			System.out.println("command input server port ");
			return;
		}

		try {
			theServer = new ServerSocket(port);
			System.out.println(port + "server socket Sucssesion");
			theServer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
