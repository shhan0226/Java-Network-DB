package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress myIP = null, myIPs[] = null;

		try {
			myIP = InetAddress.getByName("210.94.161.204");
			System.out.println("getHostName : " + myIP.getHostName());
			System.out.println("getHostAddr : " + myIP.getHostAddress());
			System.out.println("toString : " + myIP.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte inet[] = myIP.getAddress();
		System.out.print("getHostAddr : ");
		for (int i = 0; i < inet.length; i++) {
			System.out.print(inet[i] + ".");
		}

		System.out.println();
		System.out.print("getHostAddr : ");
		for (int i = 0; i < inet.length; i++) {
			System.out.print(((inet[i] < 0) ? (inet[i] + 256) : inet[i]) + ".");
		}

		System.out.println();
		try {
			myIPs = InetAddress.getAllByName("www.dongguk.edu");
			for(int i = 0; i<myIPs.length ; i++) {
				System.out.println("getHostName : " + myIPs[i].getHostName());
				System.out.println("getHostAddr : " + myIPs[i].getHostAddress());
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

