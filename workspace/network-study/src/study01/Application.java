package study01;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Application {
	public static void main(String[] args) {
		InetAddress ip = null;
		InetAddress[] ipArr = null;
		
		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println(ip.getHostName());
			System.out.println(ip.getHostAddress());
			System.out.println(ip.toString());
			System.out.println();
			
			
			byte[] ipAddr = ip.getAddress();
			StringBuilder sb = new StringBuilder();
			System.out.println(Arrays.toString(ipAddr));
			for(byte b : ipAddr) {
				if(b < 0) {
					b += 256;
				}
				sb.append(b).append('.');
			}
			System.out.println(sb.toString());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
