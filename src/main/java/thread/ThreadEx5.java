package thread;

/* 싱글/멀티 스레드 예제 ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7
*  ThreadEx5 main() 메서드에서 실행되는 스레드 하나
*  main() 안에서 ThreadEx5_1 인스턴스 실행되는 스레드 하나
*  두개가 멀티 스레드로 실행된다. 순서는 jvm, 프로세스에 의해 정해진다.
 * */

public class ThreadEx5 {

    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx5_1 th1 = new ThreadEx5_1();
        th1.start();
        startTime = System.currentTimeMillis();

        for(int i=0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("소요시간1: " +(System.currentTimeMillis()-ThreadEx5.startTime));
    }
}


class ThreadEx5_1 extends Thread{

    @Override
    public void run() {
        for(int i=0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("소요시간2: " +(System.currentTimeMillis()-ThreadEx5.startTime));
    }
}
