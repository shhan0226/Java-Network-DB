package network;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEnDecoder {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		try {
			String strData = URLEncoder.encode("it = www.dongguk.edu 123456", "EUC-KR");
			String strDeData = URLDecoder.decode(strData, "EUC-KR");
			
			System.out.println("Endcod : " + strData);
			System.out.println("Dedcod : " + strDeData);	
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
