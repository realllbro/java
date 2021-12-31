package stack_queue;

import java.util.*;

public class PriorityQueueEx {
    public static void main(String[] args){
        Queue pq = new PriorityQueue();

        pq.offer(3);    // pq.offer(new Integer(3)); 오토박싱
        pq.offer(1);
        pq.offer(5);
        pq.offer(2);
        pq.offer(4);

        System.out.println(pq); // pq의 내부 배열을 출력

        Object obj = null;

        // PriorityQueue에 저장된 요소를 하나씩 꺼낸다.
        while((obj = pq.poll()) != null){
            System.out.println(obj);
        }
    }
}

/*
    저장순서가 3,1,5,2,4 인데도 출력결과는 1,2,3,4,5 이다. 우선순위는 숫자가 작을수록 높은
    것이므로 1이 가장 먼저 출력된 것이다. 물로 숫자뿐만 아니라 객체를 저장할 수도 있는데 그럴 경우
    각 객체의 크기를 비교할 수 있는 방법을 제공해야 한다. 예제에서는 정수를 사용했는데,
    컴파일러가 Integer로 오토박싱 해준다. Integer와 같은 Number의 자손들은 자체적으로 숫자를 비교하는
    방법을 정의하고 있기 때문에 비교 방법을 지정해 주지 않아도 된다.

    참조변수 pq를 출력하면, PriorityQueue가 내부적으로 가지고 있는 배열의 내용이 출력되는데, 저장한 순서와
    다르게 저장되었다. 힙이라는 자료구조의 형태로 저장된 것이라서 그렇다. (jvm힙 아님)

    [1, 2, 5, 3, 4]
    1
    2
    3
    4
    5
 */