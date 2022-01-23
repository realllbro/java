package exception;

public class ExceptionEx14 {
    public static void main(String[] args)throws Exception{
        try {
            method1();
        }catch (Exception e){
            System.out.println("main메서드에서 예외가 처리되었습니다.");
            e.printStackTrace();
        }
    }
    static void method1() throws Exception{
        throw new Exception();
    }
}

/* 실행결과
    main메서드에서 예외가 처리되었습니다.
    java.lang.Exception
        at exception.ExceptionEx14.method1(ExceptionEx14.java:13)
        at exception.ExceptionEx14.main(ExceptionEx14.java:6)
 */
