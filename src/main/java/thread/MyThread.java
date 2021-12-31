package thread;

public class MyThread extends Thread{

    @Override
    public void run() { //Thread클래스의 run()을 오버라이딩
        /* 작업내용 */
    }
}


class MyThread_1 implements Runnable{
    @Override
    public void run() {	//Runnable인터페이스의 run()을 구현
        /* 작업내용 */
    }
}
