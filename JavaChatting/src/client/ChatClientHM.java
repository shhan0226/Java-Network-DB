package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ChatClientHM {

	public ChatClientHM() {

		SocketAddress address = new InetSocketAddress("127.0.0.1", 5000);

		try (SocketChannel socketChannel = SocketChannel.open(address)) {

			System.out.println("Connected to Chat Server");
			String message;
			Scanner scanner = new Scanner(System.in);

			while (true) {
				System.out.println("Waiting for message from the server ...");
				System.out.println("Message: " + HelperMethods.receiveFixedLengthMessage(socketChannel));
				System.out.println(">");

				message = scanner.nextLine();

				if (message.equalsIgnoreCase("quit")) {
					HelperMethods.sendFixedLengthMessage(socketChannel, "Client terminationg");
					break;

				}

				HelperMethods.sendFixedLengthMessage(socketChannel, message);
			}

		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ChatClientHM();

	}

}
