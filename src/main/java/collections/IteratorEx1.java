package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorEx1 {
    public static void main(String[] args){
        Collection list = new ArrayList();
        //ArrayList list = new ArrayList();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        Iterator it = list.iterator();

        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
/*
출력결과 :

    1
    2
    3
    4
    5

List클래스들은 저장순서를 유지하기 때문에 Iterator를 이용해서 읽어 온 결과 역시 저장 순서와 동일하지만
Set클래스들은 각 요소간의 순서가 유지 되지 않기 때문에 Iterator를 이용해서 저장된 요소들을 읽어 와도
처음에 저장된 순서와 같지 않다.

 */