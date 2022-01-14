package exception;

public class ExceptionEx11 {
    public static void main(String[] args){
        throw new RuntimeException();      // RuntimeException을 고의로 발생시킨다.
    }
}

/* 실행결과
    Exception in thread "main" java.lang.RuntimeException
        at exception.ExceptionEx11.main(ExceptionEx11.java:5)
 */
