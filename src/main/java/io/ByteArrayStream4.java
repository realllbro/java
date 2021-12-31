package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * 바이트기반 스트림
 * ByteArrayInputStream / ByteArrayOutputStream
 * ByteArrayInputStream / ByteArrayOutputStream 은 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림이다.
 * 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트 배열에 담아서 변환 등의 작업을 하는데 사용된다.
 */
public class ByteArrayStream4 {
	public static void main(String[] args) {
			
		/* byte 0 ~ 255 정수 */
		// input byte 배열
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};

		// output byte 배열
		byte[] outSrc = null;

		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		// 배열 내용을 String 으로 리턴
		System.out.println("Input Source  : "+ Arrays.toString(inSrc));
		
		try {
			while(input.available() > 0) {
				int len = input.read(temp);			//읽어 온 데이터의 개수를 반환한다.
				output.write(temp, 0 ,len);	//읽어 온 만큼만 write 한다.
				
				outSrc = output.toByteArray();
				
				System.out.println("temp : "+ Arrays.toString(temp));
				System.out.println("Output Source : "+ Arrays.toString(outSrc));				
			}
		}catch(IOException e) {}
	}
		
	/*
		Input Source  : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		temp : [0, 1, 2, 3]
		Output Source : [0, 1, 2, 3]
		temp : [4, 5, 6, 7]
		Output Source : [0, 1, 2, 3, 4, 5, 6, 7]
		temp : [8, 9, 6, 7]
		Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] 
		
	ByteArrayStream3 문제점을 수정한 것이다.
	출력할 때, temp에 저장된 모든 내용을 출력하는 대신 값을 읽어온
	만큼만 출력하도록 변경했다.
		
	 */
}
