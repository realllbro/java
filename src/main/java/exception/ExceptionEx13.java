package exception;

public class ExceptionEx13 {
    public static void main(String[] args)throws Exception{
        method1();      // 같은 클래스내의 static멤버이므로 객체생성없이 직접 호출가능.
    }
    static void method1() throws Exception{
        try {
            throw new Exception();
        }catch (Exception e){
            System.out.println("method1메서드에서 예외가 처리되었습니다.");
            e.printStackTrace();
        }
    }
}

/* 실행결과
    method1메서드에서 예외가 처리되었습니다.
    java.lang.Exception
        at exception.ExceptionEx13.method1(ExceptionEx13.java:9)
        at exception.ExceptionEx13.main(ExceptionEx13.java:5)
 */
