package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	public static void main(String args[]) {
		ServerSocket serverSocket = null;

		try {
			// 서버 소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
		}catch(IOException e) {
			e.printStackTrace();
		}

		while(true) {
			try {
				System.out.println(getTime()+"연결 요청을 기다립니다.");

				// 서버 소켓을 클라이언트의 연결 요청이 올 때 까지 실행을 멈추고 계속 기다린다.
				// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로 부터 연결요청이 들어왔습니다.");

				// 소켓의 출력 스트림을 얻는다.
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);

				// 원격 소켓(remote socket)에 데이터를 보낸다.
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime()+"데이터를 전송했습니다.");

				// 소켓의 입력스트림을 얻는다.
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);

				// 소켓으로 부터 받은 데이터를 출력한다.
				System.out.println("서버로 부터 받은 메시지 : "+dis.readUTF());
				System.out.println("연결을 종료합니다.");

				dis.close();

				// 스트림과 소켓을 닫아준다.
				dos.close();
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 현재 시간을 문자열로 반환하는 함수
	public static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}