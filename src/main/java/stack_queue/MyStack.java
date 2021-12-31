package stack_queue;
import java.util.*;


/*
 * Stack은 컬렉션 프레임웍 이전부터 존재하던 것이기 때문에 ArrayList가 아닌 Vector로 부터 상속받아 구현하였다.
 * Stack의 실제코드를 이해하기 쉽게 약간 수정해서 MyStack을 만들어 보았다.
 * 스택을 자바코드로 어떻게 구현하였는지 이해하는데 많은 도움이 될 것이다.
 * Vector에 구현되어 있는 메서드를 이용하기 때문에 코드도 간단하고 어렵지 않다.
 */

class MyStack extends Vector{
    public Object push(Object item){
        addElement(item);
        return item;
    }

    public Object pop(){
        Object obj = peek();                //Stack에 저장된 마지막 요소를 읽어온다.

        // 만일 Stack이 비어있으면 peek()메서드가 EmptyStackException을 발생 시킨다.
        // 마지막 요소를 삭제한다. 배열의 index가 0 부터 시작하므로 1을 빼준다.
        removeElementAt(size()-1);
        return obj;
    }

    public Object peek(){
        int len = size();

        if(len == 0)
            throw new EmptyStackException();
        // 마지막 요소를 반환한다. 배열의 index가 0 부터 시작하므로 1을 빼준다.
        return elementAt(len - 1);
    }

    public boolean empty(){
        return size() == 0;
    }

    public int search(Object o){
        int i = lastIndexOf(o);     // 끝에서 부터 객체를 찾는다.

        if(i >= 0){ // 객체를 찾은 경우
            return size() -i;   // Stack은 맨 위에 저장된 객체의 index를 1로 정의하기 때문에 계산을 통해서 구한다.
        }
        return -1; // 해당 객체를 찾지 못하면 -1를 반환한다.
    }
}