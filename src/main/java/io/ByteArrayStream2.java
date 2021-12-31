package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/*
 * 바이트기반 스트림
 * ByteArrayInputStream / ByteArrayOutputStream
 * ByteArrayInputStream / ByteArrayOutputStream 은 메모리, 즉 바이트배열에 데이터를 입출력 하는데 사용되는 스트림이다.
 * 주로 다른 곳에 입출력하기 전에 데이터를 임시로 바이트 배열에 담아서 변환 등의 작업을 하는데 사용된다.
 */
public class ByteArrayStream2 {
	public static void main(String[] args) {

		/* byte 0 ~ 255 정수 */
		// input byte 배열
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};

		// output byte 배열
		byte[] outSrc = null;

		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		//최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off)부터 저장한다. 
		//실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.				
		//읽어 온 데이터를 배열 temp에 담는다		
		input.read(temp, 0, temp.length);	
		
		//주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서 출력소스에 쓴다.		
		//temp[5]부터 5개의 데이터를 write한다.
		output.write(temp, 5, 5); 	
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source  : "+ Arrays.toString(inSrc));
		System.out.println("temp	      : "+ Arrays.toString(temp));		
		System.out.println("Output Source : "+ Arrays.toString(outSrc));
		/*
		 Input Source  : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		 temp	       : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		 Output Source : [5, 6, 7, 8, 9]
		 */
		
		/*
		 * byte배열(temp)을 사용해서 한 번에 배열의 크기만큼 읽고 쓸 수 있다. 바구니(배열temp)를 이용하면 한 번에 
		 * 더 많은 물건을 옮길 수 있는 것과 같다고 이해하면 좋을 것이다.
		 * byte배열 temp의 크기(temp.length)가 10이라서 10byte를 읽어 왔지만 output에 출력 할 때는 temp[5]부터 5byte만 출력 하였다.
		 * 배열을 이용한 입출력은 작업의 효율을 증가시키므로 가능하면 입출력 대상에 따라 알맞은 크기의 배열을 사용하는 것이 좋다 
		 */
	}
}
