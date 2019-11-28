package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class PartsClient {

	public PartsClient() {
		System.out.println("Worker Started");
		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);
		try (SocketChannel socketChannel = SocketChannel.open(address)) {
			System.out.println("Connected to Parts Server");
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("Enter part name: ");
				String partName = scanner.nextLine();

				if (partName.equalsIgnoreCase("quit")) {
					HelperMethods.sendMessage(socketChannel, "quit");
					break;
				} else {
					HelperMethods.sendMessage(socketChannel, partName);
					System.out.println("The Result is " + HelperMethods.receiveMessage(socketChannel));
				}

			}

			System.out.println("Worekr Terminated");

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PartsClient();

	}

}
