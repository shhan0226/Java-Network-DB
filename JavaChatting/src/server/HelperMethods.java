package server;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class HelperMethods {

	public static void sendFixedLengthMessage(SocketChannel socketChannel, String message) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(64);
			buffer.put(message.getBytes());
			buffer.flip();
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}
			System.out.println("Sent : " + message);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String receiveFixedLengthMessage(SocketChannel socketChannel) {
		String message = "";
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(64);
			socketChannel.read(byteBuffer);  //소켓으로부터 버퍼에 저장하기 저장(-->)
			byteBuffer.flip(); //버퍼 저장 방향 변경
			while (byteBuffer.hasRemaining()) { //.has 한개 데이터가 있을경우 true
				message += (char) byteBuffer.get(); //.get은 현재위치 byte 단위로 가져오기
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return message;
	}

	public static void sendMessage(SocketChannel socketChannel, String message) {
		try {
			ByteBuffer buffer = ByteBuffer.allocate(message.length() + 1);
			buffer.put(message.getBytes());
			buffer.put((byte) 0x00);
			buffer.flip();
			while (buffer.hasRemaining()) {
				socketChannel.write(buffer);
			}
			System.out.println("Sent : " + message);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String receiveMessage(SocketChannel socketChannel) {
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(16);
			String message = "";
			while (socketChannel.read(byteBuffer) > 0) {
				char byteRead = 0x00;
				byteBuffer.flip();
				while (byteBuffer.hasRemaining()) {
					byteRead = (char) byteBuffer.get();
					if (byteRead == 0x00) {
						break;
					}
					message += byteRead;
				}
				if (byteRead == 0x00) {
					break;
				}
				byteBuffer.clear();
			}
			return message;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return "";
	}

}
