package exception;

public class ExceptionEx2 {
    public static void main(String args[]){
        int number = 100;
        int result = 0;

        for(int i=0; i < 10; i++) {
            result = number / (int) (Math.random() * 10);   // 9번째 라인
            System.out.println(result);
        }
    }
}

/* 실행결과

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at exception.ExceptionEx2.main(ExceptionEx2.java:9)

 */
