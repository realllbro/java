package io;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

public class FileEx1 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io/FileEx1.java");
		
		String fileNmae = f.getName();
		int pos = fileNmae.lastIndexOf(".");
		
		System.out.println(" 경로를 제외한 파일이름"+ f.getName());
		System.out.println(" 확장자를 제외한 파일이름"+ fileNmae.substring(0,pos));		
		System.out.println(" 확장자 - "+ fileNmae.substring(pos+1));
		
		System.out.println(" 경로를 포함한 파일이름"+ f.getPath());
		
		//파일시스템의 루트(root)로부터 시작하는 파일의 전체 경로(OS에 따라서 둘이상의 절대 경로가 존재 할 수 있다 현재 디렉토리를 의미하는 '.'와 같은 기호나 링크 등을 포함하는 경우)
		System.out.println(" 파일의 절대경로"+ f.getAbsolutePath());
		
		//기호나 링크를 포함하지 않는 유일한 경로 
		System.out.println(" 파일의 정규경로"+ f.getCanonicalPath());		
		System.out.println(" 파일의 속해 있는 디렉토리"+ f.getParent());		
		System.out.println();
		System.out.println(" File.pathSeparator - "+ File.pathSeparator);
		System.out.println(" File.pathSeparatorChar - "+ File.pathSeparatorChar);		
		System.out.println(" File.separator - "+ File.separator);						
		System.out.println(" File.separatorChar - "+ File.separatorChar);				
		System.out.println();
		
		//현재 프로그램이 실행중인 디렉토리
		System.out.println(" user.dir = "+ System.getProperty("user.dir"));	
		//classpath
		System.out.println(" sun.boot.class.path = "+ System.getProperty(" sun.boot.class.path"));
		
		
	/* 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","FileEx1.java");
		또는
		File dir = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io");
		File f = new File(dir, "FileEx1.java");
		
		File 인스턴스를 생성했다고 해서 파일이나 디렉토리가 생성되는 것은 아니다.
		파일명이나 디렉토리명으로 지정된 문자열이 유효하지 않더라도 컴파일 에러나 예외를 발생시키지 않는다.
		새로운 파일을 생성하기 위해서는 File 인스턴스를 생성한 다음, 출력스트림을 생성하거나 createNewFile()을 호출해야 한다.
		
		1. 이미 존재하는 파일을 참조할 때 : 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","FileEx1.java");
		
		2. 기존에 없는 파일을 새로 생성할 때: 
		File f = new File("C:/devbro/study/project/sts_workspace/essence_java/src/ch15_io","NewFile.java");
		f.createNewFile();	//새로운 파일이 생성된다.
	*/		
		
	}
}
