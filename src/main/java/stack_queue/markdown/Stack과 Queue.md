# Stack 과 Queue
스택은 마지막에 저장한 데이터를 가장 먼저 꺼내게 되는 LIFO(Last In First Out)구조로 되어 있고,    
큐는 처음에 저장한 데이터를 가장 먼저 꺼내게 되는 FIFO(First In First Out)구조로 되어 있다.     
스택은 통과 같은 구조로 한 방향으로만 넣고 뺄 수 있는 구조이고,   
큐는 위 아래로 뚫려 있어서 한 방향으로는 넣고 한 방향으로는 빼는 파이프와 같은 구조로 되어 있다.

예를 들어 스택에 0, 1, 2의 순서로 데이터를 넣었다면 꺼낼 때는 2, 1, 0의 순서로 꺼내게 된다.     
즉, 넣은 순서와 꺼낸 순서가 뒤집어지게 되는 것이다.  
이와 반대로 큐에 0, 1, 2의 순서로 데이터를 넣었다면 꺼낼 때 역시 0, 1, 2 의 순서로 꺼내게 된다.      
순서의 변경 없이 먼저 넣은 것을 먼저 꺼내게 되는 것이다.   

순차적으로 데이터를 추가하고 삭제하는 스택에는 ArrayList와 같은 배열기반의 컬렉션 클래스가 적합하지만,       
큐는 데이터를 꺼낼 때 항상 첫 번째 저장된 데이터를 삭제하므로, ArrayList와 같은 배열기반의 컬렉션 클래스를   
사용한다면 데이터를 꺼낼 때마다 빈 공간을 채우기 위해 데이터의 복사가 발생하므로 비효율적이다.   
그래서 큐는 ArrayList보다 데이터의 추가/삭제가 쉬운 LinkedList로 구현하는 것이 더 적합하다.


# Stack 메서드 
|메서드 |설명 |
|:----------|:----------|
|boolean empty()|Stack이 비어있는지 알려준다.|
|Object peek()|Stack의 맨 위에 저장된 객체를 반환. pop()과 달리 Stack에서 객체를 꺼내지는 않음.<br>(비었을 때는 EmptyStackException발생)|
|Object pop()|Stack의 맨 위에 저장된 객체를 꺼낸다.(비었을 때는 EmptyStackException발생)|
|Object push(Object item)|Stack에 객체(item)를 저장한다.|
|int search(Object o)|Stack에서 주어진 객체(o)를 찾아서 그 위치를 반환. 못찾으면 -1을 반환.<br>(배열과 달리 위치는 0이 아닌 1부터 시작) 객체(item)를 저장한다.|

# Queue 메서드
|메서드 |설명 |
|:----------|:----------|
|boolean add(Object o)|지정된 객체를 Queue에 추가한다. 성공하면 ture를 반환. 저장공간이 부족하면.<br> IllegalStateException 발생|
|Object remove()|Queue에서 객체를 꺼내 반환. 비어있으면 NoSuchElementException발생|
|Object element()|삭제없이 요소를 읽어온다. peek와 달리 Queue가 비었을 때 NoSuchElementException 발생|
|boolean offer(Object o)|Queue에 객체를 저장. 성공하면 true, 실패하면 false를 반환|
|Object poll()|Queue에서 객체를 꺼내서 반환. 비어있으면 null을 반환|
|Object peek()|삭제없이 요소를 읽어 온다. Queue가 비어 있으며 null을 반환|

* 예제 StackQueueEx.java 

```java
import java.util.*;

class StackQueueEx{
    public static void main(String[] args){
        Stack st = new Stack();
        Queue q = new LinkedList();     //Queue 인터페이스의 구현체인 LinkedList를 사용

        st.push("0");
        st.push("1");
        st.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("= Stack =");
        while(!st.empty()){
            System.out.println(st.pop());
        }

        System.out.println("= Queue =");
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

    }
}

/*
    실행결과

    = Stack =
    2
    1
    0
    = Queue =
    0
    1
    2

 */
```

자바에서는 스택을 Stack클래스로 구현하여 제공하고 있지만 큐는 Queue인터페이스로만 정의해   
놓았을 뿐 별도의 클래스를 제공하고 있지 않다. 대신 Queue인터페이스를 구현한 클래스들이 있어서     
이 들 중의 하나를 선택해서 사용하면 된다. Java API 'All Known Implementing Classes' 항목 참고해서  
'Queue q = new LinkedList();' 와 같은 식으로 객체를 생성해서 사용하면 된다.    

# Stack 직접 구현하기
Stack은 컬렉션 프레임웍 이전부터 존재하던 것이기 때문에 ArrayList가 아닌 Vector로 부터 상속받아          
구현하였다. Stack의 실제코드를 이해하기 쉽게 약간 수정해서 MyStack을 만들어 보았다.              
스택을 자바코드로 어떻게 구현하였는지 이해하는 많은 도움이 될 것이다.

```java
import java.util.*;

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
```

# 스택과 큐의 활용     
스택의 활용 예 : 수식계산, 수식괄호검사, 워드프로세서의 undo/redo, 웹브라우저의 뒤로/앞으로              
큐의 활용 예 : 최근사용문서, 인쇄작업 대기목록, 버퍼(buffer)

* 예제 StackEx1.java

```java
import java.util.*;

public class StackEx1 {
    public static Stack back = new Stack();
    public static Stack forward = new Stack();

    public static void main(String[] args){
        goURL("1.네이트");
        goURL("2.야후");
        goURL("3.네이버");
        goURL("4.다음");

        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른 후 =");
        printStatus();

        goBack();
        System.out.println("= '뒤로' 버튼을 누른 후 =");
        printStatus();

        goForward();
        System.out.println("= '앞으로' 버튼을 누른 후 =");
        printStatus();

        goURL("codechobo.com");
        System.out.println("= 새로운 주소로 이동 후 =");
        printStatus();
    }

    public static void printStatus(){
        System.out.println("back:"+back);
        System.out.println("forward:"+forward);
        System.out.println("현재화면은 '"+back.peek()+"' 입니다.");
        System.out.println();
    }

    public static void goURL(String url) {
        back.push(url);
        if (!forward.empty())
            forward.clear();
    }

    public static void goForward() {
        if (!forward.empty())
            back.push(forward.pop());
    }

    public static void goBack() {
        if (!back.empty())
            forward.push(back.pop());
    }
}

/*
    back:[1.네이트, 2.야후, 3.네이버, 4.다음]
    forward:[]
    현재화면은 '4.다음' 입니다.

    = '뒤로' 버튼을 누른 후 =
    back:[1.네이트, 2.야후, 3.네이버]
    forward:[4.다음]
    현재화면은 '3.네이버' 입니다.

    = '뒤로' 버튼을 누른 후 =
    back:[1.네이트, 2.야후]
    forward:[4.다음, 3.네이버]
    현재화면은 '2.야후' 입니다.

    = '앞으로' 버튼을 누른 후 =
    back:[1.네이트, 2.야후, 3.네이버]
    forward:[4.다음]
    현재화면은 '3.네이버' 입니다.

    = 새로운 주소로 이동 후 =
    back:[1.네이트, 2.야후, 3.네이버, codechobo.com]
    forward:[]
    현재화면은 'codechobo.com' 입니다.

 */

```

* 예제 ExpValidCheck.java

```java
import java.util.EmptyStackException;
import java.util.Stack;

public class ExpValidCheck {
    public static void main(String[] args){
        if(args.length!=1){
            System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
            System.out.println("Example : java ExpValidCheck \"((2+3)*1)+3\"");
            System.exit(0);
        }

        Stack st = new Stack();
        String expression = args[0];

        System.out.println("expression : "+expression);

        try{
            for(int i=0; i < expression.length(); i++){
                char ch = expression.charAt(i);

                if(ch=='('){
                    //Stack에 객체(item)를 저장한다.
                    st.push(ch+"");
                } else if(ch==')'){
                    //Stack의 맨 위에 저장된 객체를 꺼낸다.(비었을 때는 EmptyStackException발생)
                    st.pop();
                    //st.peek();
                }
            }

            System.out.println("스택 사이즈 "+st.size());
            st.forEach(System.out::println);

            System.out.println(st.isEmpty());

            //Stack이 비어있는지 알려준다. 비었으면 true
            if(st.isEmpty()) {
                System.out.println("괄호가 일치합니다.");
            }else{
                System.out.println("괄호가 일치하지 않습니다.");
            }
        }catch(EmptyStackException e){
            System.out.println("catch 괄호가 일치하지 않습니다.");
        }
    }
}

/*
    출력결과

    - st.pop();
      expression : (2+3)*1
      스택 사이즈 0
      true
      괄호가 일치합니다.

    - st.peek();
      expression : (2+3)*1
      스택 사이즈 1
      (
      false
      괄호가 일치하지 않습니다.

 */
```
입력한 수식의 괄호가 올바른지를 체크하는 예제이다. '('를 만나면 스택에 넣고 ')'를 만나면           
스택에서 '('를 꺼낸다. ')'를 만나서 '('를 꺼내려 할 때 스택이 비어 있거나 수식을 검사하고            
난 후에도 스택이 비어있지 않으면 괄호가 잘못된 것이다.         

')'를 만나서 '('를 꺼내려 할 때 스택이 비어 있으면 EmptyStackException 이 발생하므로 try-catch문을            
이용해서 EmptyStackException 이 발생하면 괄호가 일치하지 않는다는 메시지를 출력하도록 했다.            

stack push, pop 에 관한 예제이며 pop 으로 호출하면 객체를 꺼내게 되며 stack 은 빈 상태가 된다.          
peek() 인 경우는 저장된 객체만 반환하며 실제 꺼내지는 않는다.          

* 예제 QueueEx1.java

```java
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
```

유닉스의 history 명령어를 Queue를 이용해서 구현한 것이다.          
history 명령어는 사용자가 입력한 명령어의 이력을 순서대로 보여 준다.          
여기서는 최근 5개의 명령어만을 보여주는데 MAX_SIZE 의 값을 변경함으로써        
더 많은 명령어 입력기록을 남길 수 있다.         
대부분의 프로그램이 최근에 열어 본 문서들의 목록을 보여 주는 기능을 제공하는데,       
이 기능도 위의 예제를 응용하면 쉽게 구현할 수 있을 것이다.          
(queue 에 넣고 빼고 확인)      

# PriorityQueue
Queue인터페이스의 구현체 중의 하나로, 저장한 순서에 관계없이 우선순위가(priority)가 높은 것부터    
꺼내게 된다는 특징이 있다. 그리고 null은 저장할 수 없다. null을 저장하면 NullPointerException 이 발생한다.      
PriorityQueue는 저장공간으로 배열을 사용하며, 각 요소를 '힙(heap)' 이라는 자료구조의 형태로 저장한다.         
이진트리의 한 종류로 가장 큰 값이나 가장 작은 값을 빠르게 찾을 수 있다는 특징이 있다.              
※ 자료구조 힙(heap)은 JVM의 힙(heap)과 이름만 같은 뿐 다른 것이다.  

* 예제 PriorityQueueEx.java

```java
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
    [1, 2, 5, 3, 4]
    1
    2
    3
    4
    5
 */
```

저장순서가 3,1,5,2,4 인데도 출력결과는 1,2,3,4,5 이다. 우선순위는 숫자가 작을수록 높은           
것이므로 1이 가장 먼저 출력된 것이다. 물로 숫자뿐만 아니라 객체를 저장할 수도 있는데 그럴 경우         
각 객체의 크기를 비교할 수 있는 방법을 제공해야 한다. 예제에서는 정수를 사용했는데,            
컴파일러가 Integer로 오토박싱 해준다. Integer와 같은 Number의 자손들은 자체적으로 숫자를 비교하는            
방법을 정의하고 있기 때문에 비교 방법을 지정해 주지 않아도 된다.           

참조변수 pq를 출력하면, PriorityQueue가 내부적으로 가지고 있는 배열의 내용이 출력되는데, 저장한 순서와           
다르게 저장되었다. 힙이라는 자료구조의 형태로 저장된 것이라서 그렇다. (jvm힙 아님)           

# Deque(Double-Ended Queue) 너무적게 나옴 추가로 공부 필요..     
Queue의 변형으로, 한 쪽 끝으로만 추가/삭제할 수 있는 Queue와 달리, Deque(덱, 또는 디큐라고 읽음)은      
양쪽 끝에 추가/삭제가 가능하다. Deque의 조상은 Queue이며, 구현체로는 ArrayDeque과 LinkedList 등이 있다.      

덱은 스택과 큐를 하나로 합쳐놓은 것과 같으며 스택으로 사용할 수도 있고, 큐로 사용할 수도 있다.     
위의 그림과 아래의 표를 같이 보면 어렵지 않게 이해할 수 있을 것이다.

|Deque|Queue|Stack|
|:---|:---|:---|
|offerLast()|offer()|push()|
|pollLast()|-|pop()|
|pollFirst()|poll()|-|
|peekFirst()|peek()|-|
|peekLast()|-|peek()|

덱(Deque)의 메서드에 대응하는 큐와 스택의 메서드
