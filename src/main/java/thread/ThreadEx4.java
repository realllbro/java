package thread;

/* 싱글/멀티 스레드 예제 ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7 */
public class ThreadEx4 {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();

        for(int i=0; i < 300; i++) {
            System.out.printf("%s", new String("-"));
        }
        System.out.println("소요시간1: " +(System.currentTimeMillis()-startTime));

        for(int i=0; i < 300; i++) {
            System.out.printf("%s", new String("|"));
        }
        System.out.println("소요시간2: " +(System.currentTimeMillis()-startTime));
    }
}
