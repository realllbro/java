package exception;

public class ExceptionEx3 {
    public static void main(String args[]){
        int number = 100;
        int result = 0;

        for(int i=0; i < 10; i++) {
            try {
                result = number / (int) (Math.random() * 10);   // 9번째 라인
                System.out.println(result);
            }catch(ArithmeticException e) {
                System.out.println("0");
            }
        }
    }
}

/* 실행결과
    20
    16
    0       <-- ArithmeticException 발생 구간
    20
    16
    12
    100
    50
    100
    33
 */
