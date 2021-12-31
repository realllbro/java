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
public class ByteArrayStream1 {
    public static void main(String[] args) {

        /* byte 0 ~ 255 정수 */
        // input byte 배열
        byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};

        // output byte 배열
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        int data = 0;

        //1byte를 읽어 온다(0~255사이의값).더 이상 읽어 올 데이터가 없으면 -1을 반환한다.
        while((data = input.read()) != -1) {
            //void write(int b)	주어진 값을 출력소스에 쓴다.
            output.write(data);
        }

        //스트림의 내용을 byte배열로 반환한다.
        outSrc = output.toByteArray();

        System.out.println("Input Source : "+ Arrays.toString(inSrc));
        System.out.println("Output Source : "+ Arrays.toString(outSrc));

	/*
		Input Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		Output Source : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

	    바이트배열(ByteArray)은 사용하는 자원이 메모리 밖에  없으므로 가비지컬렉터에 의해 자동적으로 자원을 반환하므로 close()를 이용해서 스트림을 닫지 않아도 된다.
	    read()와 write(int b)를 사용하기 때문에 한 번에 1 byte만 읽고 쓰므로 작업효율이 떨어진다.
	 */

    }
}