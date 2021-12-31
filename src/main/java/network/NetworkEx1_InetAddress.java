package network;

import java.net.*;
import java.util.*;

public class NetworkEx1_InetAddress {

/*
	IP 주소를 다루기 위한 클래스 InetAddress

	byte[] getAddress()
		=> IP주소를 byte배열로 반환한다.

	static InetAddress[] getAllByName(String host)
		=> 도메인명(host)에 지정된 모든 호스트의 IP 주소를 배열에 담아 반환한다.

	static InetAddress getByAddress(byte[] addr)
		=>  byte배열을 통해 IP 주소를 얻는다.

	static InetAddress getByName(String host)
		=>  도메인명(host)을 통해 IP주소를 얻는다.

	String getCanonicalHostName()
		=>  FQDN(fully qualified domain name)을 반환한다.

	String getHostAddress()
		=> 호스트의 IP주소를 반환한다.

	String getHostName()
		=> 호스트의 이름을 반환한다.

	static InetAddress getLocalHost()
		=> 지역호스트의 IP주소를 반환한다.

	boolean isMulticastAddress()
		=> IP주소가 멀티캐스트 주소인지 알려준다

	boolean isLoopbackAddress()
		=> IP주소가 loopback 주소(127.0.0.1)인지 알려준다.
*/

	public static void main(String[] args) {

		InetAddress ip = null;
		InetAddress[] ipArr = null;

		try {
			ip = InetAddress.getByName("www.naver.com");
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println("toString() : "+ip.toString());

			System.out.println("getCanonicalHostName() : "+ip.getCanonicalHostName());


			byte[] ipAddr = ip.getAddress();
			System.out.println("getAddress() :"+Arrays.toString(ipAddr));

			// ?????? 뭐지...
			String result = "";
			for(int i=0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ?  ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}

			System.out.println("getAddress() + 256 : "+result);
			System.out.println();

		/*
			getHostName() : www.naver.com
			getHostAddress() : 125.209.222.141
			toString() : www.naver.com/125.209.222.141
			getAddress() :[125, -47, -34, -115]
			getAddress()+256 : 125.209.222.141.
		 */

		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			ip = InetAddress.getLocalHost();
			System.out.println("getHostName() : "+ip.getHostName());
			System.out.println("getHostAddress() : "+ip.getHostAddress());
			System.out.println();

		/*
			getHostName() : SKCC16N01065
			getHostAddress() : 10.250.107.251
		 */

		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

		try {
			ipArr = InetAddress.getAllByName("www.naver.com");

			for(int i=0; i < ipArr.length; i++) {
				System.out.println("ipArr["+i+"] : "+ipArr[i]);
			}

		/*
			ipArr[0] : www.naver.com/125.209.222.141
			ipArr[1] : www.naver.com/223.130.195.95
		 */

		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}

