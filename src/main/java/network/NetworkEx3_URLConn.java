package network;

import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class NetworkEx3_URLConn {
	/*
		void addRequestProperty (String key,String value)
			=> 지정된 키와 값을 RequestProperty에 추가한다. 기존에 같은 키가 있어도 값을 덮어쓰지 않는다.

		void connect()
			=> URL에 지정된 자원에 대한 통신연결을 연다.

		boolean getAllowUserlnteraction()
			=> Userlnteraction의 허용여부를 반환한다.

		int getConnectTimeout()
			=> 연결종료시간을 천분의 일초로 반환한다.

		Object getContent()
			=> content객체를 반환한다.

		Object getContent (Class[ ] classes)
			=> content객체를 반환한다.

		String getContentEncoding()
			=> content의 인코딩을 반환한다.

		int getContentLength()
			=> content의 크기를 반환한다.

		String getContentType()
			=> content의 type을 반환한다.

		long getDate()
			=> 헤더 (header)의 date필드의 값을 반환한다.

		boolean getDefaultAllowUserlnteraction()
			=> defaultAllowUserlnteraction의 값을 반환한다.

		String getDefaultRequestProperty (String key)
			=> RequestProperty에서 지정된 키의 디폴트값을 얻는다.

		boolean getDefaultUseCaches()
			=> useCache의 디폴트 값을 얻는다.

		boolean getDolnput()
			=> dolnput필드값을 얻는다.

		boolean getDoOutput()
			=> doOutput필드값을 얻는다.

		long getExpiration()
			=> 자원 (URL)의 만료일자를 얻는다.(천분의 일초단위)

		FileNameMap getFileNameMap()
			=> FileNameMap (mimetable)을 반환한다.

		String getHeaderField (int n)
			=> 헤더의 n번째 필드를 읽어온다.

		String getHeaderField (String name)
			=> 헤더에서 지정된 이름의 필드를 읽어온다.

		long getHeaderFieldDate (String name,long Default)
			=> 지정된 필드의 값을 날짜값으로 변환하여 반환한다. 필드값이 유효하지 않을 경우 Default값을 반환한다.

		int getHeaderFieldlnt (String name,int Default)
			=> 지정된 필드의 값을 정수값으로 변환하여 반환한다. 필드값이 유효하지 않을 경우 Default값을 반환한다.

		String getHeaderFieldKey (int n)
			=> 헤더의 n번째 필드를 읽어온다.

		Map getHeaderFields()
			=> 헤더의 모든 필드와 값이 저장된 Map을 반환한다.

		long getlfModifiedSince()
			=> ifModifiedSince (변경여부)필드의 값을 반환한다.

		InputStream getinputStream()
			=> URLConnetion에서 InputStream을 반환한다.

		long getLastModified()
			=> LastModified (최종변경일) 필드의 값을 반환한다.

		OutputStream getOutputStream( )
			=> URLConnetion에서 OutputStream을 반환한다

		Permission getPermission()
			=> Permission (허용권한)을 반환한다.

		int getReadTimeout()
			=> 읽기제한시간의 값을 반환한다.(천분의 일초)

		Map getRequestProperties()
			=> RequestProperties에 저장된 (키, 값)을 Map으로 반환

		String getRequestProperty (String key)
			=> RequestProperty에서 지정된 키의 값을 반환한다.

		URL getURL()
			=> URLConnection의 URL의 반환한다.

		boolean getUseCaches()
			=> 캐쉬의 사용여부를 반환한다.

		String guessContentTypeFromName(String fname)
			=> 지정된 파일 (fname)의 content-type을 추측하여 반환한다.

		String guessContentTypeFromStream(InputStream is)
			=> 지정된 입력스트림 (is)의 content-type을 추측하여 반환한다.

		void setAllowUserinteraction(boolean allowuserinteraction)
			=> UserInteraction의 허용여부를 설정한다.

		void setConnectTimeout (int timeout)
			=> 연결종료시간을 설정한다.

		void setContentHandlerFactory(ContentHandlerFactory fac)
			=> ContentHandlerFactory를 설정한다.

		void setDefaultAllowUserlnteraction(boolean defaultallowuserinteraction)
			=> Userinteraction허용여부의 기본값을 설정한다.

		void setDefaultRequestProperty(String key, String value)
			=> RequestProperty의 기본 키쌍 (key-pair)을 설정한다.

		void setDefaultUseCaches (boolean defaultusecaches)
			=> 캐쉬 사용여부의 기본값을 설정한다.

		void getDoInput (boolean doinput)
			=> Dolnput필드의 값을 설정한다.
			   InputStream 으로 POST 데이터를 넘겨 주겠다는 옵션?

		void setDoOutput (boolean dooutput)
			=> DoOutput필드의 값을 설정한다. BODY로 데이터 넘길때 옵션 false 면 안간다.
			   OutputStream으로 post 데이터를 넘겨주겠다는 옵션?

		FileNameMap을 설정한다.
			=> void setFileNameMap (FileNameMap map)

		void setlfModifiedSince (long ifmodifiedsince)
			=> ModifiedSince필드의 값을 설정한다.

		void setReadTimeout (int timeout)
			=> 읽기제한시간을 설정한다. (천분의 일초)

		void setRequestProperty (String key,String value)
			=> setRequestProperty (key, value) 를 저장한다.

		void setUseCaches (boolean usecaches)
			=> 캐쉬의 사용여부를 설정한다.
	 */

	public static void main(String[] args) {
		URL url = null;
		String address = "http://www.codechobo.com/sample/hello.html";
		address = "http://localhost:8090/fileservice/getFile?";

		try {
			url = new URL(address);
			/*URL간의 통신연결을 나타내는 클래스의 최상위 클래스 하위로 HttpURLConnection, JarURLConnection 이 있으며
			 URL 프로토콜이 http 프로토콜 이라면 openConnection()은 Http URLConnection을 반환한다*/
			URLConnection conn = url.openConnection();

			System.out.println("conn.toString() : "+ conn.toString());
			System.out.println("conn.getAllowUserInteraction() : "+ conn.getAllowUserInteraction());
			System.out.println("conn.getConnectTimeout() : "+ conn.getConnectTimeout());
			System.out.println("conn.getContent() : "+ conn.getContent());
			System.out.println("conn.getContentEncoding() : "+ conn.getContentEncoding());
			System.out.println("conn.getContentLength() : "+ conn.getContentLength());
			System.out.println("conn.getContentType() : "+ conn.getContentType());
			System.out.println("conn.getDate() : "+ conn.getDate());
			System.out.println("conn.getDefaultAllowUserInteraction() : "+ conn.getDefaultAllowUserInteraction());
			System.out.println("conn.getDefaultUseCaches() : "+ conn.getDefaultUseCaches());
			System.out.println("conn.getDoInput() : "+ conn.getDoInput());
			System.out.println("conn.getDoOutput() : "+ conn.getDoOutput());
			System.out.println("conn.getExpiration() : "+ conn.getExpiration());
			System.out.println("conn.getHeaderFields() : "+ conn.getHeaderFields());
			System.out.println("conn.getIfModifiedSince() : "+ conn.getIfModifiedSince());
			System.out.println("conn.getLastModified() : "+ conn.getLastModified());
			System.out.println("conn.getReadTimeout() : "+ conn.getReadTimeout());
			System.out.println("conn.getURL() : "+ conn.getURL());
			System.out.println("conn.getUseCaches() : "+ conn.getUseCaches());
			
/*
	conn.toString() : sun.net.www.protocol.http.HttpURLConnection:http://localhost:8090/fileservice/getFile?
	conn.getAllowUserInteraction() : false
	conn.getConnectTimeout() : 0
	conn.getContent() : sun.net.www.content.text.PlainTextInputStream@50f8360d
	conn.getContentEncoding() : null
	conn.getContentLength() : 9246
	conn.getContentType() : text/plain; charset=ISO-8859-1
	conn.getDate() : 1613554752000
	conn.getDefaultAllowUserInteraction() : false
	conn.getDefaultUseCaches() : true
	conn.getDoInput() : true
	conn.getDoOutput() : false
	conn.getExpiration() : 0
	conn.getHeaderFields() : {null=[HTTP/1.1 200 OK], Server=[Apache-HttpCore/5.0.3 (Java/15.0.1)], Connection=[keep-alive], Content-Length=[9246], Date=[Wed, 17 Feb 2021 09:39:12 GMT], Content-Type=[text/plain; charset=ISO-8859-1]}
	conn.getIfModifiedSince() : 0
	conn.getLastModified() : 0
	conn.getReadTimeout() : 0
	conn.getURL() : http://localhost:8090/fileservice/getFile?
	conn.getUseCaches() : true			
 */
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

