package exception;

public class ExceptionEx8 {
    public static void main(String args[]){
        System.out.println(1);
        System.out.println(2);
        try{
            System.out.println(3);
            System.out.println(0/0);    //강제로 ArithmeticException 발생
            System.out.println(4);      //실행되지 않는다.
        }catch (ArithmeticException ae){
            ae.printStackTrace();
            System.out.println("예외메시지 : " + ae.getMessage());
        }
        System.out.println(6);
    }
}
/*
 실행결과
    1
    2
    3
    예외메시지 : / by zero
    6
    java.lang.ArithmeticException: / by zero
        at exception.ExceptionEx8.main(ExceptionEx8.java:9)
순서가 이상하네 ?????
 */
