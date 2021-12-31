import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

package network;

/**
 * Http Client 클래스
 */
public class HttpClient {
	
	/**
	 * 요청받은 정보로 원격지 서버와 통신 합니다. 기본 charset UTF-8 적용
	 * @param reqUrl
	 * @param httpMethod
	 * @param requestBody
	 * @param reqProperty
	 * @return 수신데이터
	 * @throws IOException
	 */
	public String execute(String reqUrl, String httpMethod, String requestBody, Map<String, String> reqProperty) throws IOException {
		return execute(reqUrl, httpMethod, requestBody, reqProperty, "UTF-8");
	}
	
	/**
	 * 요청받은 정보로 원격지 서버와 통신 합니다. 
	 * @param reqUrl
	 * @param httpMethod
	 * @param requestBody
	 * @param reqProperty
	 * @param charset
	 * @return 수신데이터
	 * @throws IOException
	 */
	public String execute(String reqUrl, String httpMethod, String requestBody, Map<String, String> reqProperty, String charset) throws IOException {
		// HttpURLConnection 객체는 멀티 쓰레드 환경에서 thread-safe 하지 않으므로 로컬변수로 변경한다.
		HttpURLConnection httpURLConn = null;
		
		try {
			//request Url 연결
			httpURLConn = openConnection(reqUrl, httpMethod, reqProperty);
			
			//post방식으로 body에 request 송신
			if(null != requestBody) {
				sendRequestBody(httpURLConn, requestBody, charset);	
			}
			//response 수신
			return receiveResponseBody(httpURLConn, charset);
		}catch(Exception e)	{
			throw new IOException("NodeManager connection error. ", e); // (중요) Exception 재생성후 throw 시에는 반드시 cause 를 담아야함 
		}finally {
			closeConnection(httpURLConn);
		}
	}
	
	/**
	 * reqUrl 과 연결된 HttpURLConnection 을 얻고 header 정보를 세팅합니다. 
	 * @param reqUrl
	 * @param httpMethod
	 * @param reqProperty
	 * @throws IOException
	 */
	private HttpURLConnection openConnection(String reqUrl, String httpMethod, Map<String, String> reqProperty) throws IOException {
		//URL address
		URL url = new URL(reqUrl);
		
		//HttpURLConnection
		HttpURLConnection httpURLConn = (HttpURLConnection)url.openConnection();
		
		//Header 세팅
		httpURLConn.setRequestMethod(httpMethod);
		
		// 클라이언트가 처리 가능한 미디어 타입
		httpURLConn.setRequestProperty("Accept", "application/json");	
		
		// 본문의 미디어 타입(MIME) ex) application/json, text/html
		httpURLConn.setRequestProperty("Content-Type", "application/json");
		
		// 노드메니저에 3초 이상 connect 안되면 에러로 본다.
		httpURLConn.setConnectTimeout(3000);
		
		// 단순 소스 파일 읽어오는 것이므로 5초 이상 걸리면 다른 문제가 있는 것으로 보고 에러낸다.
		httpURLConn.setReadTimeout(10000); 
		
		// 파라메터로 넘어온게 있으면 요청값으로 set
		if(null != reqProperty) {
			for(String key : reqProperty.keySet()) {
				httpURLConn.setRequestProperty(key, reqProperty.get(key));	
			}
		}
		
		return httpURLConn;
	}	
	
	/**
	 * httpMethod 가 POST 일때 reqUrl 에게 송신할 데이터를 String(문자열) 로 받아 OutputStream 으로 전송합니다.
	 * @param httpURLConn
	 * @param reqBody
	 * @param charset
	 * @throws Exception
	 */
	private void sendRequestBody(HttpURLConnection httpURLConn, String reqBody, String charset) throws IOException {
		
		httpURLConn.setDoOutput(true);

		OutputStream os = httpURLConn.getOutputStream();
		
		try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, charset))) {
			writer.write(reqBody);
			writer.flush();
		}
	}	
	
	/**
	 * reqUrl 에서 수신된 결과를 inputStream 으로 받아 String(문자열) 로 return 해 줍니다.
	 * @param httpURLConn   
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	private String receiveResponseBody(HttpURLConnection httpURLConn, String charset) throws IOException {
		
		int resCode = httpURLConn.getResponseCode();
		
		//입력스트림 생성
		InputStream inputStream = null;
		BufferedReader bufferedReader = null;
		StringWriter sw  = new StringWriter(1024);
		PrintWriter  out = new PrintWriter(sw);
		
		try{
			//성공
			if(resCode >= 200 && resCode < 300) {
				inputStream = httpURLConn.getInputStream();
			}
			//오류 
			else {
				inputStream = httpURLConn.getErrorStream();
			}
			
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
			
			String line;

			while((line=bufferedReader.readLine())!=null) {
				out.println(line); // new line 문자도 보존하기 위해 PrintWriter 로 변경
			}
			out.flush();
			return sw.toString();
		}catch(Exception e) {
			throw new IOException("Http response read error.", e);
		}finally {
			if(bufferedReader != null) bufferedReader.close(); // bufferedReader close 하면, 내부 stream 들도 모두 close 됨.  
		}
	}	
	
	/**
	 * 연결을 종료 합니다.
	 * @param httpURLConn
	 */
	private void closeConnection(HttpURLConnection httpURLConn) {
		try {
			if (httpURLConn!=null) {
				httpURLConn.disconnect();
			}
		}catch(Exception ignore) {
		}
	}
}
