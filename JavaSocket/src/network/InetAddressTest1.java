package network;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class InetAddressTest1 {
	
	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress address;

		address = InetAddress.getLocalHost();
		System.out.println("local computer : " + address.getHostName());
		System.out.println("local IP Address : " + address.getHostAddress());

		address = InetAddress.getByName("www.dongguk.edu");
		System.out.println("www.dongguk.edu IP Address : " + address);

		InetAddress sw[] = InetAddress.getAllByName("ucloud-lab.dongguk.edu");

		for (int i = 0; i < sw.length; i++) {
			System.out.println(sw[i]);
		}
	}

}
