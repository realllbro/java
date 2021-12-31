package thread;

public class ThreadEx1 {
    public static void main(String args[]) {
        ThreadEx1_1 t1 = new ThreadEx1_1("상속 받은 Thread extends");

        Runnable r = new ThreadEx1_2();
        Thread t2 = new Thread(r,"인터페이스 상속받아 implements");		//생성자 Thread(Runnable target)

		/* 한줄로 표현
		Thread t2 = new Thread(new ThreadEx1_2());
		*/

        t1.start();
        t2.start();

		/*
		쓰레드의 이름은 생성자나 메서드를 통해서 지정 또는 변경 할 수 있다.
		Thread(Runnable target, String name)
		Thread(String name)
		void setName(String name)
		*/


    }
}

//Thread 를 상속받아서 사용
class ThreadEx1_1 extends Thread{

    public ThreadEx1_1(){}

    public ThreadEx1_1(String threadNm) {
        super.setName(threadNm);
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println(getName());	// 상속받은(조상인) Thread의 getName()을 호출
        }
    }
}

//Runnable 인터페이스를 구현
class ThreadEx1_2 implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            // Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			/*
			 Thread t = Thread.currentThread();
			 String name = t.getName();
			 System.out.println(name);
			 */
            System.out.println(Thread.currentThread().getName());
        }
    }

}