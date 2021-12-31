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
public class ByteArrayStream3 {
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
				//배열 temp의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다. 반환하는 값은 항상 배열의 크기보다 작거나 같다.
				input.read(temp);
				
				//주어진 배열 temp에 저장된 모든 내용을 출력소스에 쓴다.
				output.write(temp);
				
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
		Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, "6, 7]"
			
		available()	은 블락킹(blocking)없이 읽어 올 수 있는 바이트의 수를 반환한다.
		아마도 예상과 다른 결과가 나왔을 텐데 그 이유는 마지막에 읽은 배열의 9번째와 10번째 요소값인 8과 9만을 
		출력해야 하는데 temp 에 남아 있던 6, 7까지 출력했기 때문이다.
		보다 나은 성능을 위해서 temp에 담긴 내용을 지우고 쓰는 것이 아니라 그냥 기존의 내용 위에 덮어 쓴다.
		그래서 temp의 내용은 [4,5,6,7] 이었는데, 8과 9를 읽고 난 후에는 [8,9,6,7]이 된다.
		
		원하는 결과를 얻기 위해서는 아래와 같이 수정해야 한다.
		첫번째 코드는 배열의 내용전체를 출력하지만,
		두번째 코드는 읽어온 만큼(len)만 출력한다.

		while(input.available() > 0) {
			input.read(temp);
			output.write(temp);
		}
		
		=>
		
		while(input.available() > 0) {
			int len = input.read(temp);
			output.write(temp, 0 ,len);
		}	
		
	 */
}
