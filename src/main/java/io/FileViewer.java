package io;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 2. 바이트기반 스트림
 * 2.3 FileInputStream / FileOutputStream
 * 
 * FileInputStream / FileOutputStream 은 파일에 입출력을 하기 위한 스트림이다.
 */

public class FileViewer {
/*	
	FileInputStream(String name) 
		=> 지정된 파일이름(name)을 가진 실제 파일과 연결된 FileInputStream을 생성한다.
		
	FileInputStream(File file)
		=> 파일의 이름이 String이 아닌 File인스턴스로 지정해 주어야 하는 점을 제외하고 FileInputStream(String name)과 같다
		
	FileInputStream(FileDescriptor fdObj)
		=> 파일 디스크립터(fdObj)로 FileInputStream을 생성한다.
		
	FileOutputStream(String name)
		=> 지정된 파일이름(name)을 가진 실제 파일과의 연결된 FileOutputStream을 생성한다.
		
	FileOutputStream(String name, boolean append)
		=> 지정된 파일이름(name)을 가진 실제 파일과 연결된 FileOutputStream을 생성한다. 
		   두번째 인자인 append를 true로 하면, 출력 시 기존의 파일내용의 마지막에 덧붙인다. false면, 기존의 파일내용을 덮어쓰게 된다.
		   
    FileOutputStream(File file)
    	=> 파일의 이름을 String이 아닌 File 인스턴스로 지정해주어야 하는 점을 제외하고 FileOutputStream(String name)과 같다.
    	
	FileOutputStream(File file, boolean append)
		=> 파일의 이름을 String이 아닌 File 인스턴스로 지정해주어야 하는 점을 제외하고 FileOutputStream(String name, boolean append)과 같다.	
	
	FileOutputStream(FileDescriptor fdObj)
		=> 파일 디스크립터(fdObj)로 FileOutputStream 생성한다.	
*/
	public static void main(String args[])throws IOException{
		
		FileInputStream fis = new FileInputStream(args[0]);
		int data = 0;
		
		while((data=fis.read())!=-1) {
			char c = (char)data;
			System.out.print(c);
		}
	}
	
	/*
	 * read()의 반환값이 int형(4 byte) 이긴 하지만, 더 이상 입력값이 없음을 알리는 -1을 제외하고는 
	 * 0~255(1 byte) 범위의 정수값이기 때문에, char형(2 byte)으로 변환한다 해도 손실되는 값은 없다.
	 * read()가 한 번에 1 byte씩 파일로 부터 데이터를 읽어 들이긴 하지만, 데이터의 범위가 십진수로 0~255(16진수로는 0x00 ~ 0xff) 범위의 정수값이고,
	 * 또 읽을 수 있는 입력값이 더 이상 없음을 알릴 수 있는 값(-1)도 필요하다. 그래서 다소 크긴 하지만 정수형 중에서는 연산이 
	 * 가장 효율적이고 빠른 int형 값을 반환하도록 한 것이다.
	 * 
	 */
	
	
	
}
