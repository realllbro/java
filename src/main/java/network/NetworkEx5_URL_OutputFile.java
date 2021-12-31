package network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class NetworkEx5_URL_OutputFile {
	public static void main(String[] args) {
		URL url = null;
		InputStream in = null;
		FileOutputStream out = null;
		String address = "http://www.codechobo.com/book/src/javajungsuk3_src.zip";
		address = "https://github.com/castello/javajungsuk3/raw/master/java_jungsuk3e_src_20170601.zip";

		int ch = 0;

		try {
			url = new URL(address);
			in = url.openStream();

			//이진데이터를 읽어서 파일에 저장한다. output으로 생성할 파일선언
			out = new FileOutputStream("javajungsuk3_src.zip");

			while((ch=in.read()) != -1) {
				System.out.println(ch);
				//FileOutputStream 으로 write 한다.
				out.write(ch);
			}

			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
