package network;

import java.net.URL;

public class NetworkEx2_URL {
	
/*	
	URL (String spec)
		=> 지정된 문자열 정보의 URL객체를 생성한다.

	URL (String protocol, String host, String file)
		=> 지정된 값으로 구성된 URL객체를 생성한다.

	URL (String protocol, String host, int port, String file)
		=> 	지정된 값으로 구성된 URL객체를 생성한다.

	String getAuthority()
		=> 호스트명과 포트를 문자열로 반환한다.

	Object getContent()
		=> URL의 Content객체를 반환한다.

	Object getContent (Class[ ] classes)
		=> URL의 Content객체를 반환한다.

	int getDefaultPort()
		=> URL의 기본 포트를 반환한다.(http는 80)

	String getFile( )
		=> 파일명을 반환한다.

	String getHost( )
		=> 호스트명을 반환한다.

	String getPath()
		=> 경로명을 반환한다.

	int getPort()
		=> 포트를 반환한다.

	String getProtocol()
		=> 프로토콜을 반환한다.

	String getQuery()
		=> 쿼리를 반환한다.

	String getRef( )
		=> 참조(anchor)를 반환한다.

	String getUserinfo(()
		=> 사용자정보를 반환한다.

	URLConnection openConnection()
		=> URL과 연결된 URLConnection을 얻는다.

	URLConnection openConnection(Proxy proxy)
		=> URL과 연결된 URLConnection을 얻는다.

	InputStream openStream()
		=> URL과 연결된 URLConnection의 InputStream 을 얻는다.

	boolean sameFile(URL other)
		=> 두 URL이 서로 같은 것인지 알려준다.

	void set(String protocol, String host, int port, String file, String ref)
		=> URL객체의 속성을 지정된 값으로 설정한다.

	void set(String protocol, String host,int port, String authority, String userlnfo,String path, String query, String ref)
		=> URL객체의 속성을 지정된 값으로 설정한다.

	String toExternalForm()
		=> URL을 문자열로 변환하여 반환한다.

	URI toURI()
		=> 	URL을 URI로 변환하여 반환한다.
*/

	public static void main(String[] args) {
		try {
			//URL url = new URL("http://www.codechobo.com:80/sample/hello.html?referer=codechobo#index1");
			URL url = new URL("http://localhost:8090/fileservice/getFile?");

			System.out.println("url.getAuthority() : "+url.getAuthority());
			System.out.println("url.getContent() : "+url.getContent());
			System.out.println("url.getDefaultPort() : "+url.getDefaultPort());
			System.out.println("url.getPort() : "+url.getPort());
			System.out.println("url.getFile() : "+url.getFile());
			System.out.println("url.getHost() : "+url.getHost());
			System.out.println("url.getPath() : "+url.getPath());
			System.out.println("url.getProtocol() : "+url.getProtocol());
			System.out.println("url.getQuery() : "+url.getQuery());
			System.out.println("url.getRef() : "+url.getRef());
			System.out.println("url.getUserInfo() : "+url.getUserInfo());
			System.out.println("url.toExternalForm() : "+url.toExternalForm());
			System.out.println("url.toURI() : "+url.toURI());

/*
	url.getAuthority() : localhost:8090
	url.getContent() : sun.net.www.content.text.PlainTextInputStream@50f8360d
	url.getDefaultPort() : 80
	url.getPort() : 8090
	url.getFile() : /fileservice/getFile?
	url.getHost() : localhost
	url.getPath() : /fileservice/getFile
	url.getProtocol() : http
	url.getQuery() :
	url.getRef() : null
	url.getUserInfo() : null
	url.toExternalForm() : http://localhost:8090/fileservice/getFile?
	url.toURI() : http://localhost:8090/fileservice/getFile?
 */

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}