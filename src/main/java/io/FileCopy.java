package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 
 * 2. 바이트기반 스트림
 * 2.3 FileInputStream / FileOutputStream
 * 
 * FileInputStream / FileOutputStream 은 파일에 입출력을 하기 위한 스트림이다.
 */
public class FileCopy {
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
	public static void main(String args[]){
		
		try {
			FileInputStream fis = new FileInputStream(args[0]);
			FileOutputStream fos = new FileOutputStream(args[1]);
			
			int data = 0;
			
			while((data=fis.read())!=-1) {
				fos.write(data); 	// void write(int b) 주어진 값을 출력소스에 쓴다.
			}
			
			fis.close();
			fos.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 단순히 FileCopy.java 의 내용을 read()로 읽어서, write(int b)로 FileCopy.bak 에 출력한다.
	 * 이처럼 텍스트 파일을 다루는 경우에는 FileInputStream / FileOutputStream 보다 
	 * 문자 기반의 스트림인 FileReader / FileWriter를 사용하는 것이 더 좋다.
	 * 
	 * ※ 참고 : 기존의 파일에 새로운 내용을 추가하려면, FileOutputStream fos = new FileOutputStream(args[1], true); 와 같이
	 *          FileOutputStream(String name, boolean append) 또는 FileOutputStream(File file, boolean append) 사용한다.
	 */
	
	
	
}
