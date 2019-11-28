package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynchronousServerSocketChannelServer {

	public AsynchronousServerSocketChannelServer() {
		System.out.println("AsynchronousServer Start");
		try (AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open()) {

			InetSocketAddress hostAddress = new InetSocketAddress("localhost", 5000);
			serverChannel.bind(hostAddress);

			System.out.println("Waiting for client to connect... ");
			Future acceptResult = serverChannel.accept();

			try (AsynchronousSocketChannel clientChannel = (AsynchronousSocketChannel) acceptResult.get()) {
				System.out.println("Messages from client: ");
				while ((clientChannel != null) && (clientChannel.isOpen())) {

					ByteBuffer buffer = ByteBuffer.allocate(32);
					Future result = clientChannel.read(buffer);

					/*
					 * while (!result.isDone()) { // do nothing }
					 */

					// result.get();
					result.get(10, TimeUnit.SECONDS);

					buffer.flip();
					String message = new String(buffer.array()).trim();
					System.out.println(message);
					if (message.equals("quit")) {
						break;
					}
				}
			} catch (TimeoutException ex) {
				ex.printStackTrace();
			}

		} catch (IOException | InterruptedException | ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AsynchronousServerSocketChannelServer();
	}

}
