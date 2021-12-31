package thread;

import javax.swing.JOptionPane;

/* 싱글/멀티 스레드 예제 ThreadEx4, ThreadEx5, ThreadEx6, ThreadEx7 */
public class ThreadEx6 {

    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");

        for(int i=10; i > 0; i--) {
            System.out.println(i);
            try {
                // 현재 실행중인 main 메서드 스레드를 지연 시킨다.
                Thread.sleep(1000);	// 1초간 시간을 지연한다.
            } catch(Exception e) {}
        }
    }
}
