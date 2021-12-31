package stack_queue;

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
    입력한 수식의 괄호가 올바른지를 체크하는 예제이다. '('를 만나면 스택에 넣고 ')'를 만나면
    스택에서 '('를 꺼낸다. ')'를 만나서 '('를 꺼내려 할 때 스택이 비어 있거나 수식을 검사하고
    난 후에도 스택이 비어있지 않으면 괄호가 잘못된 것이다.

    ')'를 만나서 '('를 꺼내려 할 때 스택이 비어 있으면 EmptyStackException 이 발생하므로 try-catch문을
    이용해서 EmptyStackException 이 발생하면 괄호가 일치하지 않는다는 메시지를 출력하도록 했다.

    stack push, pop 에 관한 예제이며 pop 으로 호출하면 객체를 꺼내게 되며 stack 은 빈 상태가 된다.
    peek() 인 경우는 저장된 객체만 반환하며 실제 꺼내지는 않는다.

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
