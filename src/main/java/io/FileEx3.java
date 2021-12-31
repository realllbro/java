package io;

import java.io.File;
import java.util.ArrayList;

public class FileEx3 {
	
	static int totalFiles = 0;
	static int totalDirs = 0;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 1) {
			System.out.println("USAGE : java FileEx3 DIRECTORY");
			System.exit(0);
		}
		
		File dir = new File(args[0]);
		
		if(!dir.exists() || !dir.isDirectory()) {
			System.out.println("유효하시 않은 디렉토리입니다.");
			System.exit(0);
		}
		
		printFileList(dir);
		
		System.out.println();
		System.out.println("총 "+ totalFiles +"개의파일");
		System.out.println("총 "+ totalDirs+"개의 디렉토리");		
	}
	
	public static void printFileList(File dir) {
		System.out.println(dir.getAbsolutePath()+" 디렉토리");
		File[] files = dir.listFiles();
		
		ArrayList subDir = new ArrayList();
		
		for(int i=0; i < files.length; i++) {
			String filename = files[i].getName();
			
			if(files[i].isDirectory()) {
				filename = "[" + filename +"]";
				subDir.add(i+"");
			}
			System.out.println(filename);
		}
		
		int dirNum = subDir.size();
		int fileNum = files.length - dirNum;
		
		totalFiles += fileNum;
		totalDirs += dirNum;
		
		System.out.println(fileNum + "개의 파일, " + dirNum + "개의 디렉토리");
		System.out.println();
		
		for(int i=0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
		}
	}
}
/*
	C:\devbro\study\project\sts_workspace\essence_java\src 디렉토리
	[ch13_thread]
	[ch15_io]
	[ch16_networking]
	0개의 파일, 3개의 디렉토리
	
	C:\devbro\study\project\sts_workspace\essence_java\src\ch13_thread 디렉토리
	MyThread.java
	ThreadEx1.java
	ThreadEx4.java
	ThreadEx5.java
	ThreadEx6.java
	ThreadEx7.java
	6개의 파일, 0개의 디렉토리
	
	C:\devbro\study\project\sts_workspace\essence_java\src\ch15_io 디렉토리
	123.txt
	BufferedInputStreamBufferedOutputStream
	BufferedOutputStreamEx1.java
	FileCopy.java
	FileEx1.java
	FileEx2.java
	FileEx3.java
	FileViewer.bck
	FileViewer.java
	FilterInputStream.java
	InputStream.java
	IOEx1_ByteArray.java
	IOEx2_ByteArray.java
	IOEx3_ByteArray.java
	IOEx4_ByteArray.java
	15개의 파일, 0개의 디렉토리
	
	C:\devbro\study\project\sts_workspace\essence_java\src\ch16_networking 디렉토리
	NetworkEx1_InetAddress.java
	NetworkEx2_URL.java
	NetworkEx3_URLConn.java
	NetworkEx4_URL_InputStream.java
	NetworkEx5_URL_OutputFile.java
	TcpIpClient.java
	TcpIpServer.java
	7개의 파일, 0개의 디렉토리
	
	총 28개의파일
	총 3개의 디렉토리
	
	
	서브디렉토리와 그에 포함된 파일과 디렉토리의 목록까지 보여 주도록 하였다
	printFileList(File dir)는 디렉토리에 포함된 파일과 디렉토리의 목록을 출력하는 메서드인데
	재귀호출을 이용하였다.
	
	ArrayList subDir = new ArrayList();
	
	for(int i=0; i < files.length; i++) {
		String filename = files[i].getName();
		
		if(files[i].isDirectory()) {
			filename = "[" + filename +"]";
			subDir.add(i+"");
		}
		System.out.println(filename);
	}	
	
	먼저 파일의 목록을 출력하고 디렉토리인 경우 ArrayList에 담았다가 
	각 디렉토리에 대해 printFileList(File dir)를 재귀호출한다.
	
		for(int i=0; i < subDir.size(); i++) {
			int index = Integer.parseInt((String)subDir.get(i));
			printFileList(files[index]);
		}
		
	사실 ArrayList에 담지 않고 재귀호출만을 이용해도 처리가 가능하나 보다 정돈된 형태로 출력하기 위해서 이렇게 하였다.
	
 */


