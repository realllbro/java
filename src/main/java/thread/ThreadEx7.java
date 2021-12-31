package thread;

import javax.swing.JOptionPane;

/* 싱글/멀티 스레드 예제 ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7
*  입력값을 기다리는 동안 ThreadEx7_1 인스턴스는 스레드를 지연 시킨다.
*
* */
public class ThreadEx7 {

    public static void main(String[] args) {

        // main 외에 스레드를 생성해서 실행한다.
        ThreadEx7_1 th1 = new ThreadEx7_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

class ThreadEx7_1 extends Thread{

    @Override
    public void run() {
        for(int i=10; i > 0; i--) {
            System.out.println(i);
            try {
                // 스레드를 지연 시킨다.
                Thread.sleep(1000);	// 1초간 시간을 지연한다.
            } catch(Exception e) {}
        }
    }
}
