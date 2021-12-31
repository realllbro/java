package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx4_URL_InputStream {
	public static void main(String[] args) {
		URL url = null;
		BufferedReader input = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		address = "http://localhost:8090/fileservice/getFile?";
		String line = "";

		try {

			url = new URL(address);
			/* openStream()은 openConnection()을 호출해서 URLConnection을 얻은 다음 여기에 다시 getInputStream()을 호출한 것과 같다
			 * inputStream in = url.openStream() => 	URLConnection conn = url.openConnection();
			 * 											InputStream in = conn.getInputStream();    이 둘의 차이가 뭘까..
			 * */

			input = new BufferedReader(new InputStreamReader(url.openStream()));

			while((line=input.readLine())!=null) {
				System.out.println(line);
			}
			input.close();

		}catch(MalformedURLException ue) {
			/*URL 이 유효하지 않을시 */
			ue.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}