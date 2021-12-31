# Iterator
컬렉션 프레임웩에서는 컬렉션에 저장된 요소들을 읽어오는 방법을 표준화하였다.      
컬렉션에 저장된 각 요소에 접근하는 기능을 가진 Iterator 인터페이스를 정의하고,    
Collection 인터페이스에는 'Iterator(Iterator를 구현한 클래스의 인스턴스)'를 반환하는                
 iterator()를 정의하고 있다.   
```java
    public interface Iterator{
        boolean hasNext();
        Object next();
        void remove();
    }
    
    public interface Collection{
        ...
        public Iterator iterator();
        ...
    }
```
iterator()는 Collection 인터페이스에 정의된 메서드이므로 Collection 인터페이스의 자손인      
List 와 Set 에도 포함되어 있다. 그래서 List나 Set인터페이스를 구현하는 컬렉션은 iterator()가        
각 컬렉션의 특징에 알맞게 작성되어 있다. 컬렉션 클래스에 대해 iterator()를 호출하여 Iterator를      
얻은 다음 반복문, 주로 while 문을 사용해서 컬렉션 클래스의 요소들을 읽어 올 수 있다.        

|메서드|설명|
|:----|:----|
|boolean hasNext()|읽어 올 요소가 남아있는지 확인한다. <br/>있으면 true, 없으면 false를 반환한다.|
|Object next()|다음 요소를 읽어 온다. <br/>next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.|
|void remove()|next()로 읽어 온 요소를 삭제한다. <br/>next()를 호출한 다음에 remove()를 호출해야 한다.(선택적 기능)|      

ArrayList에 저장된 요소들을 출력하기 위한 코드는 다음과 같이 작성할 수 있다.
```java
 Collection c = new ArrayList();
 Iterator it = c.iterator();
 while(it.hasNext()){
     System.out.println(it.next());
 }
```

ArrayList 대신 Collection 인터페이스를 구현한 다른 컬렉션 클래스에 대해서도 이와 동일한 코드를 사용할 수 있다.                    
첫 줄에서 ArrayList 대신 Collection 인터페이스를 구현한 다른 컬렉션 클래스의 객체를 생성하도록 변경하기만 하면 된다.          
Iterator를 이용해서 컬렉션의 요소를 읽어오는 방법을 표준화했기 때문에 이처럼 코드의 재사용서을 높이는 것이 가능한 것이다.               
이처럼 공통 인터페이스를 정의해서 표준을 정의하고 구현하여 포준을 따르도록 함으로써 코드의 일관성을 유지하여 재사용성을                  
극대화하는 것이 객체지향 프로그래밍의 중용한 목적 중의 하나이다.                

Map인터페이스를 구현한 컬렉션 클래스는 키(key)와 값(value)을 쌍(pair)으로 저장하고 있기 때문에 iterator()를 직접 호출할 수 없고,      
그 대신 keySet()이나 entrySet()과 같은 메서드를 통해서 키와 값을 각각 따로 Set의 형태로 얻어 온 후에 다시 iterator()를 호출해야        
Iterator를 얻을 수 있다.  
```java
 Map map = new HashMap();
   ...
 
 Iterator it = map.entrySet().iterator();
   
 Set eSet = map.entrySet();
 Iterator it = eSet.iterator();
```

* 예제 IteratorEx1.java

```java 
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
 */
```

List클래스들은 저장순서를 유지하기 때문에 Iterator를 이용해서 읽어 온 결과 역시 저장 순서와 동일하지만  
Set클래스들은 각 요소간의 순서가 유지 되지 않기 때문에 Iterator를 이용해서 저장된 요소들을 읽어 와도    
처음에 저장된 순서와 같지 않다.    




# ListIterator와 Enumeration  
Enumeration은 컬렉션 프레임웍이 만들어지기 이전에 사용하던 것으로 Iterator의 구버전이라고 생각하면 된다.  
이전 버전으로 작성된 소스와의 호환을 위해서 남겨 두고 있을뿐이므로 가능하면 Enumeration대신 Iterator를 사용하자.  
 ListIterator는 Iterator를 상속받아서 기능을 추가한 것으로, 컬렉션의 요소에 접근할때 Iterator는 단방향으로만   
이동할 수 있는 데 반해 ListIterator는 양방향으로의 이동이 가능하다.  다만 ArrayLsit나 LinkedList와 같이 List 인터페이스를  
구현한 컬렉션에서만 사용할 수 있다.  
* Enumeration : Iterator의 구버젼 
* ListIterator : Iterator에 양방향 조회기능추가(List를 구현한 경우만 사용가능)  

다음은 Enumeration, Iterator, ListIterator의 메서드에 대한 설명이다.    
Enumeration과 Iterator는 메서드 이름만 다를 뿐 기능은 같고,  
ListIterator는 Iterator에 이전방향으로의 접근기능을 추가한 것일 뿐이라는 것을 알 수 있다.

* Enumeration 인터페이스의 메서드
|메서드|설명|
|:-----|:-----|
|boolean hasMoreElements()|읽어 올 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환한다.<br/> Iterator의 hasNext()와 같다.|
|Object nextElement()|다음 요소를 읽어 온다.<br/>nextElement()를 호출하기 전에 hasMoreElements()를 호출해서 읽어올 요소가 남아있는지 확인하는 것이 안전하다.<br/>Iterattor의 next()와 같다.|

* ListIterator의 메서드
|메서드|설명|
|:-----|:-----|
|void add(Object obj)|컬렉션에 새로운 객체(obj)를 추하한다.(선택적 기능)|
|boolean hasNext()|읽어 올 다음 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환|
|boolean hasPrevious()|읽어 올 이전 요소가 남아있는지 확인한다. 있으면 true, 없으면 false를 반환|
|Object next()|다음 요소를 읽어 온다.<br/>next()를 호출하기 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.|
|Object previous()|이전 요소를 읽어 온다.<br/>previous()를 호출하기 전에 hasPrevious()를 호출해서 읽어 올 요소가 있는지 확인하는 것이 안전하다.|
|int nextIndex()|다음 요소의 index를 반환한다.| 
|int previous()|이전 요소의 index를 반환한다.|
|void remove()|next() 또는 previous()로 읽어 온 요소를 삭제한다.<br/>반드시 next()나 previous()를 먼저 호출한 다음에 이 메서드를 호출해야한다.(선택적 기능)|
|void set(Object obj)|next() 또는 previous()로 읽어 온 요소를 지정된 객체(obj)로 변경한다.<br/>반드시 next()나 previous()를 먼저 호출한 다음에 이 메서드를 호출해야한다.(선택적 기능)|

* 예제 ListIteratorEx1.java
```java
 import java.util.ArrayList;
 import java.util.Collection;
 import java.util.ListIterator;
 
 public class ListIteratorEx1 {
     public static void main(String[] args){
 
         ArrayList list = new ArrayList();
 
         list.add("1");
         list.add("2");
         list.add("3");
         list.add("4");
         list.add("5");
 
         ListIterator it = list.listIterator();
 
         while(it.hasNext()){
             System.out.print(it.next());  // 순방향으로 진행하면서 읽어온다.
         }
         System.out.println();
 
         while(it.hasPrevious()){
             System.out.print(it.previous());    // 역방향으로 진행하면서 읽어온다.
         }
         System.out.println();
     }
 }
 /*
 출력결과
 12345
 54321 
  */
```

ListIterator의 사용방법을 보여주는 간단한 예제이다.  
Iterator는 단방향으로만 이동하기 때문에 컬렉션의 마지막 요소에 다다르면 더 이상 사용할 수 없지만,   
ListIterator는 양방향으로 이동하기 때문에 각 요소간의 이동이 자유롭다.   
다만 이동하기 전에 반드시 hasNext()나 hasPrevious()를 호출해서 이동할 수 있는지 확인해야 한다.    

메서드 중에서 '선택적 기능(optional operation)' 이라고 표시된 것들은 반드시 구현하지 않아도 된다.  
예를 들어 Iterator인터페이스를 구현하는 클래스에서 remove()는 선택적인 기능이므로 구현하지 않아도 괜찮다.  
그렇다하더라도 인터페이스로부터 상속받은 메서드는 추상메서드라 메서드의 몸통(body)을 반드시 만들어 주어야   
하므로 다음과 같이 처리한다.  
```java
 public void remove(){
    throw new UnsupportedOperationException();   
 }
```
단순히 public void remove(){}와 같이 구현하는 것보다 이처럼 예외를 던져서 구현되지 않은 기능이라는 것을   
메서들 호출하는 쪽에 알리는 것이 좋다. 그렇지 않으면 호출하는 쪽에서는 소스를 구해보기 전까지는 이 기능이 바르게   
동작하지 않는 이유를 알 방법이 없다.  

Java API문서에서 remove()메서드의 상세내용을 보면 remove메서드를 지원하지 않는 Iterator는 UnsupportedOperationException    
을 발생시킨다고 쓰여 있다. 즉, remove메서드를 구현하지 않는 경우에는 UnsupportedOperationException을 발생시키도록 구현   
하라는 뜻이다.  
 위의 코드에서 remove메서드의 선언부에 예외처리를 하지 않은 이유는 UnsupportedOperationException이 RuntimeException의   
자손이기 때문이다.  Iterator의 remove()는 단독으로 쓰일 수 없고, next()와 같이 써야한다. 특정위치의 요소를 삭제하는 것이  
아니라 읽어 온 것을 삭제한다. next()의 호출없이 remove()를 호출하면, IllegalStateException이 발생한다.   
'마이크로소프트 아웃룩'과 같은 email 클라이언트에서 메일서버에 있는 메일을 가져올 때 서버에 있는 메일을 읽어만 올 것인지(copy),
메일을 가져오면서 서버에서 삭제할 것(move)인지를 선택할 수 있다. 이와 같은 기능을 구현하고자 할 때 쓸 목적으로 remove()를 
정의해 놓은 것이다.  
단순히 서버에서 읽어 오기만 할 때는 next()를 사용하면 되고, 읽어 온 메일을 서버에 남기지 않고 지울 때는 next()와 함께 
remove()를 사용하면 이와 같은 기능을 구현할 수 있다.  

* 예제 IteratorEx2.java

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorEx2 {
    public static void main(String[] args){
        ArrayList original = new ArrayList(10);
        ArrayList copy1 = new ArrayList(10);
        ArrayList copy2 = new ArrayList(10);

        for(int i=0; i < 10; i++) {
            original.add(i + "");
        }

        Iterator it = original.iterator();

        while(it.hasNext()){
            copy1.add(it.next());
        }

        System.out.println("= Original에서 copy1로 복사(copy) =");
        System.out.println("original:"+original);
        System.out.println("copy1:"+copy1);
        System.out.println();

        it = original.iterator(); // Iterator는 재사용이 안되므로, 다시 얻어와야 한다.

        while(it.hasNext()){
            copy2.add(it.next());
            it.remove();
        }

        System.out.println("= Original에서 copy2로 복사(move) =");
        System.out.println("original:"+original);
        System.out.println("copy2:"+copy2);
        System.out.println();

    }
}

/*
    출력결과

    = Original에서 copy1로 복사(copy) =
    original:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    copy1:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

    = Original에서 copy2로 복사(move) =
    original:[]
    copy2:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

 */
```


