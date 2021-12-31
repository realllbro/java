package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient {
	public static void main(String args[]) {
		try {
			String serverIp = "127.0.0.1";

			System.out.println("서버에 연결중입니다. 서버IP : "+serverIp);

			// 소켓을 생성하여 연결을 요청한다.
			Socket socket = new Socket(serverIp,7777);

			// 소켓의 입력스트림을 얻는다.
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);

			// 소켓으로 부터 받은 데이터를 출력한다.
			System.out.println("서버로 부터 받은 메시지 : "+dis.readUTF());
			System.out.println("연결을 종료합니다.");

			// 소켓의 출력 스트림을 얻는다.
			OutputStream out = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(out);

			// 원격 소켓(remote socket)에 데이터를 보낸다.
			dos.writeUTF("Client 에서 데이터를 전송했습니다.");
			System.out.println("데이터를 전송했습니다.");

			dos.close();

			// 스트림과 소켓을 닫는다.
			dis.close();
			socket.close();
			System.out.println("연결이 종료 되었습니다.");

		}catch(ConnectException ce) {
			ce.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
