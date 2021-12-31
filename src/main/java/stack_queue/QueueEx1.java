package stack_queue;

import java.util.*;

public class QueueEx1 {
    static Queue q = new LinkedList();
    static final int MAX_SIZE = 5;  // Queue에 최대 5개 까지만 저장되도록 한다.

    public static void main(String[] args) {
        System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");

        while (true) {
            System.out.println(">>");

            try {
                // 화면으로 부터 라인단위로 입력 받는다.
                Scanner s = new Scanner(System.in);
                String input = s.nextLine().trim();

                if ("".equals(input)) continue;

                if (input.equalsIgnoreCase("q")) {
                    System.exit(0);
                } else if (input.equalsIgnoreCase("help")) {
                    System.out.println("help - 도움말을 보여줍니다.");
                    System.out.println("q 또는 Q - 프로그램을 종료합니다.");
                    System.out.println("history - 최근에 입력한 명령어를 " + MAX_SIZE + " 개 보여줍니다.");
                } else if (input.equalsIgnoreCase("history")) {
                    int i = 0;
                    //입력받은 명령어를 저장하고,
                    save(input);

                    //LinkedList의 내용을 보여준다.
                    LinkedList tmp = (LinkedList) q;
                    ListIterator it = tmp.listIterator();

                    while (it.hasNext())
                        System.out.println(++i + "." + it.next());
                } else {
                    save(input);
                    System.out.println(input);
                }
            } catch (Exception e) {
                System.out.println("입력 오류입니다.");
            }
        } //while(true)
    } //main()

    public static void save(String input) {
        //queue에 저장한다.
        if (!"".equals(input))
            q.offer(input);
        //queue의 최대크기를 넘으면 제일 처음 입력된 것을 삭제한다.
        if (q.size() > MAX_SIZE) //size() 는 Collection 인터페이스에 정의
            q.remove();
    }
} //end of class

/*
    유닉스의 history 명령어를 Queue를 이용해서 구현한 것이다.
    history 명령어는 사용자가 입력한 명령어의 이력을 순서대로 보여 준다.
    여기서는 최근 5개의 명령어만을 보여주는데 MAX_SIZE 의 값을 변경함으로써
    더 많은 명령어 입력기록을 남길 수 있다.
    대부분의 프로그램이 최근에 열어 본 문서들의 목록을 보여 주는 기능을 제공하는데,
    이 기능도 위의 예제를 응용하면 쉽게 구현할 수 있을 것이다.


    queue 에 넣고 빼고 확인

    help를 입력하면 도움말을 볼 수 있습니다.
    >>
     help
    help - 도움말을 보여줍니다.
    q 또는 Q - 프로그램을 종료합니다.
    history - 최근에 입력한 명령어를 5 개 보여줍니다.
    >>
     cd
    cd
    >>
     hh
    hh
    >>
     zz
    zz
    >>
     aa
    aa
    >>
    history
     1.cd
     2.hh
     3.zz
     4.aa
     5.history
    >>
     jj
    jj
    >>
     history
    1.zz
    2.aa
    3.history
    4.jj
    5.history
    >>`



 */