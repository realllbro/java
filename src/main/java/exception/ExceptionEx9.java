package exception;

public class ExceptionEx9 {
    public static void main(String args[]){
        try{
            Exception e = new Exception("고의로 발생시켰음.");
            throw e;    // 예외를 발생시킴
        //  throw new Exception("고의로 발생시켰음.");  위 두줄을 한줄로 표현
        }catch(Exception e){
            System.out.println("에러 메시지 : "+e.getMessage());
            e.printStackTrace();
        }
        System.out.println("프로그램이 정상 종료 되었음.");
    }
}
/* 실행결과
    에러 메시지 : 고의로 발생시켰음.
    프로그램이 정상 종료 되었음.
    java.lang.Exception: 고의로 발생시켰음.
        at exception.ExceptionEx9.main(ExceptionEx9.java:6)
 */