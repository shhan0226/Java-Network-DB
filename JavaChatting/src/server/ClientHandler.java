package server;

import java.nio.channels.SocketChannel;

import server.HelperMethods;

public class ClientHandler implements Runnable {
	private final SocketChannel socketChannel;

	public ClientHandler(SocketChannel socketChannel) {
		this.socketChannel = socketChannel;
	}

	public void run() {
		System.out.println("ClientHandler Started for " + this.socketChannel);
		String partName;

		while (true) {
			partName = HelperMethods.receiveMessage(socketChannel);
			if (partName.equalsIgnoreCase("quit") || partName.equalsIgnoreCase("")) {
				break;
			} else {
				Float price = PartsServer.getPrice(partName);
				HelperMethods.sendMessage(socketChannel, "" + price);
			}
		}
		System.out.println("ClientHandler Terminated for " + this.socketChannel);
	}

}
