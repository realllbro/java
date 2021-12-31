package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedOutputStreamEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream fos = new FileOutputStream("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io/123.txt");
			
			//BufferedOutputStream의 버퍼 크기를 5로 한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			
			//파일 123.txt에 1 부터 9까지 출력한다.
			for(int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			fos.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 크기가 5인 BufferedOutputStream을 이용해서 파일 123.txt에 1부터 9까지 출력하는 예제인데
	 * 결과를 보면 5까지만 출력된 것을 알 수 있다. 그 이유는 버퍼에 남아있는 데이터가 출력되지 못한
	 * 상태로 프로그램이 종료되었기 때문이다.
	 * 이 예제에서 fos.close()를 호출해서 스트림을 닫아주기는 했지만, 이렇게 해서는 BufferedOutputStream의
	 * 버퍼에 있는 내용이 출력되지 않는다. bos.close();와 같이 해서 BufferedOutputStream의 close()를 호출해 주어야
	 * 버퍼에 남아잇던 모든 내용이 출력된다. BufferedOutputStream의 clsoe()는 기반 스트림인 FileOutputStream의 close()를
	 * 호출하기 때문에 FileOutputStream의 close()는 따로 호출해 주지 않아도 도니다.
	 * 
	 * 아래의 코드는 BufferedOutputStream의 조상인 FilterOutputStream의 소스코드인데 FilterOutputStream에 정의된
	 * close()는 flush()를 호출한 다음에 기반스트림의 close()를 호출하는 것을 알 수 있다. 
	 * BufferedOutputStream는 FilterOutputStream의 close()를 오버라이딩 없이 그대로 상속받는다.
	 * 
		public class FilterOutputStream extends OutputStream{
			
			protected OutputStream out;
			
			public FilterOutputStream(OutputStream out) {
				this.out = out;
			}
			
			public void close() throws IOException{
				try {
					flush();
				}catch(IOException ignored) {}
				out.close();	// 기반 스트림의 close()를 호출한다.
			}
		}
		
	 * 이처럼 보조스트림을 사용한 경우에는 기반스트림의 close()나 flush()를 호출할 필요없이 단순히 보조스트림의 
	 * close()를 호출하기만 하면 된다.
	 * 
	 */
	


}
