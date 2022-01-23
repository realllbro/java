package exception;

public class ExceptionEx12 {
    public static void main(String[] args)throws Exception{
        method1();      // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
    }
    static void method1() throws Exception{
        method2();
    }
    static void method2() throws Exception{
        throw new Exception();
    }
}

/* 실행결과
    Exception in thread "main" java.lang.Exception
        at exception.ExceptionEx12.method2(ExceptionEx12.java:11)
        at exception.ExceptionEx12.method1(ExceptionEx12.java:8)
        at exception.ExceptionEx12.main(ExceptionEx12.java:5)
 */
