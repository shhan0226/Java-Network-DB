package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

public class PartsServer {

	private static final HashMap<String, Float> parts = new HashMap<>();

	public PartsServer() {
		System.out.println("Server Started");
		initializeParts();
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(new InetSocketAddress(5000));

			while (true) {
				System.out.println("Waiting for Worker ...");
				SocketChannel socketChannel = serverSocketChannel.accept();
				new Thread(new ClientHandler(socketChannel)).start();
			}

		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	private void initializeParts() {
		parts.put("Han", 166f);
		parts.put("You", 1.35f);
		parts.put("kang", 4.65f);
		parts.put("kim", 8.45f);
	}

	public static Float getPrice(String partName) {
		return parts.get(partName);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PartsServer();

	}

}
