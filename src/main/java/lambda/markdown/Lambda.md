# 람다식(Lambda expression)

## 1.1 람다식이란?
람다식(Lambda expression)은 메서드를 하나의 식(expression)으로 표현한 것이다    
람다식은 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해준다.   
메서드를 람다식으로 표현하면 메서드의 이름과 반환값이 없어지므로, 람다식을 익명함수(anonumous function) 이라고도 한다

```java
    int[] arr = new int[5];
    Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);
```

위의 문장에서 () ->(int)(Math.random()*5)+1 이 바로 람다식이다. 이 람다식이 하는 일을 메서드로 표현하면 다음과 같다.

```java
    int method(){
       return (int) (Math.random()*5)+1;
    }
```

위의 메서드보다 람다식이 간겨하면서도 이해하기 쉽다는 것에 이견이 없을 것이다. 게다가 모든 메서드는 클래스에 포함되어야 하므로   
클래스도 새로 만들어야 하고, 객체도 생성해야만 비로소 이 메서드를 호출할 수 있다. 그러나 람다식은 이 모든 과정없이 오직 람다식  
자체만으로도 이 메서드의 역할을 대신할 수  있다. 게다가 람다식은 메서드의 매개변수로 전달되어지는 것이 가능하고, 메서드의 결과로    
반환될 수도 있다. 람다식으로 인해 메서드를 변수처럼 다루는 것이 가능해진 것이다.

```
※ 메서드와 함수의 차이?     
전통적으로 프로그래밍에서 함수라는 이름은 수학에서 따온 것입니다. 수학의 함수와 개념이 유사하기 때문이죠.   
그러나 객체지향개념에서는 함수(function)대신 객체의 행위나 동작을 의미하는 메서드(method)라는 용어를 사용합니다.    
메서드는 함수와 같은 의미이지만, 특정 클래스에 반드시 속해야 한다는 제약이 있기 때문에  기존의 함수와 같은 의미의   
다른 용어를 선택해서 사용한 것 입니다. 그러나 이제 다시 람다식을 통해 메서드가 하나의 독립적인 기능을 하기 때문에 
함수라는 용어를 사용하게 되었습니다.
```

## 1.2 람다식 작성하기
람다식은 '익명 함수' 답게 메서드에서 이름과 반환타입을 제거하고 매개변수 선언부와 몸통{} 사이에 '->'를 추가한다.
```
    반환타입 메서드이름(매개변수 선언){
        문장들
    }
        ▼

    (매개변수 선언) -> {
        문장들
    }
```

예를 들어 두 값 중에서 큰 값을 반환하는 메서드 max를 람다식으로 변환하면, 아래 처럼 된다.
```java
    int max(int a, int b){
       return a > b ? a : b;
    }

        ▼

    (int a, int b) -> {
       return a > b ? a : b;
    }    
```
반환값이 있는 메서드의 경우, return문 대신 '식 (expression')으로 대신 할 수 있다. 식의 연산결과가 자동적으로 반환값이 된다.     
이때는 '문장(statement)'이 아닌 '식' 이므로 끝에 ';'을 붙이지 않는다.
```java
    (int a, int b) -> {return a > b ? a : b;}  ▶ (int a, int b) -> a > b ? a : b
```
람다식에 선언된 매개변수의 타입은 추론이 가능한 경우는 생략할 수 있는데, 대부분의 경우에 생략가능하다. 람다식에 반환타입이 없는     
이유도 항상 추론이 가능하기 때문이다.
```java
    (int a, int b) -> a > b ? a : b  ▶ (a, b) -> a > b ? a : b

    '주의(int a, b) -> a > b ? a : b 와 같이 두 매개변수 중 어느 하나의 타입만 생략하는 것은 허용되지 않는다.'
```
아래와 같이 선언된 매개변수가 하나뿐인 경우에는 괄호()를 생략할 수 있다. 단, 매개변수의 타입이 있으면 괄호()를 생략할 수 없다.
```java
    (a)     -> a * a  ▶ a     -> a * a // OK
    (int a) -> a * a     int a -> a * a // 에러
```
마찬가지로 괄호{} 안의 문장이 하나일 때는 괄호{}를 생략할 수 있다. 이 때 문장의 끝에 ';'을 붙이지 않아야 한다는 것에 주의하자.
```java
    (String name, int i) -> {
        System.out.println(name+"="+i);
    }

        ▼

    (String name, int i) ->
       System.out.println(name+"="+i)
``` 
그러나 괄호{} 안의 문장이 return문일 경우 괄호{}를 생략할 수 없다.
```java
    (int a, int b) -> { return a > b ? a : b; }    //OK
    (int a, int b) ->   return a > b ? a : b       //에러
```

람다식 변환 예제
```java
예제.1
	int max(int a, int b) {
		return a > b ? a : b;
	}
            ▼
	(int a, int b) -> {return a > b ? a:b;}
	(int a, int b) -> a > b ? a:b	
	(a,b) -> a > b ? a:b	
	
예제.2
	void printVar(String name, int i) {
		System.out.println(name+"="+i);
	}
            ▼
	(String name, int i) -> {System.out.println(name+"="+i);}
	(name, i) -> System.out.println(name+"="+i)
	
	
예제.3
	int square(int x) {
		return x * x;
	}
            ▼
	(int x) -> {return x * x;}
	(x) -> x * x
	x -> x * x
	 
예제.4
	int roll() {
		return (int)(Math.random()*6);
	}
            ▼
	() -> {return (int)(Math.random()*6);}
	() -> (int)(Math.random()*6)	
	
예제.5
	int sumArr(int[] arr) {
		int sum = 0;
		for(int i : arr)
			sum += i;
		return sum;
	}
            ▼
	(int[] arr) -> {
						int sum = 0;
						for(int i : arr)
							sum += i;
						return sum;
					}
```




## 1.3 함수형 인터페이스(Functional Interface)
자바에서 모든 메서드는 클래스 내에 포함되어야 하는데, 람다식은 어떤 클래스에 포함되는 것일까? 지금까지 람다식이 메서드와 동등한 것처럼      
설명해 왔지만, 사실 람다식은 익명 클래스의 객체와 동등하다.
```java
    (int a, int b) ->  a > b ? a : b

        ▲
        ▼

    new  Object(){
        int max(int a, int b){
            return a > b ? a : b;
        }
    }
``` 
위의 두번째 코드에서 메서드 이름 max는 임의로 붙인 것일 뿐 의미는 없다. 어쨌든 람다식으로 정의된 익명 객체의 메서드를       
어떻게 호출 할 수 있을 것인가? 이미 알고 있는 것처럼 참조변수가 있어야 객체의 메서드를 호출 할 수 있으니까      
일단 이 익명 객체의 주소를 f라는 참조변수에 저장해 보자
```java
   타입 f = (int a, int b) -> a > b ? a : b;    //참조변수의 타입을 뭘로 해야 할까?
```
그러면, 참조변수 f의 타입은 어떤 것이어야 할까? 참조형이니까 클래스 또는 인터페이스가 가능하다.     
그리고 람다식과 동등한 메서드가 정의되어 있는 것이어야 한다. 그래야만 참조변수로 익명 객체(람다식)의 메서드를 호출할 수 있기 때문이다.      
예를 들어 아래와 같이 max()라는 메서드가 정의된 MyFunction인터페이스가 정의되어 있다고 가정하자.
```java
   interface MyFunction{
       public abstract int max(int a, int b);
   }
```
그러면 이 인터페이스를 구현한 익명 클래스의 객체는 다음과 같이 생성할 수 있다.
```java
   MyFunction f = new MyFunction(){
       public int max(int a, int b){
           return a > b ? a : b;
       }
   }
   int big = f.max(5,3);    //익명 객체의 메서드를 호출
```
MyFunction 인터페이스에 정의된 메서드 max()는 람다식 '(int a, int b) -> a > b ? a : b' 와 메서드의 선언부가 일치한다.       
그래서 위 코드의 익명 객체를 람다식으로 아래와 같이 대체할 수 있다.
```java
MyFunction f = (int a, int b) -> a > b ? a : b; //익명 객체를 람다식으로 대체
int big = f.max(5,3);    //익명 객체의 메서드를 호출
```
이처럼 MyFunction 인터페이스를 구현한 익명 객체를 람다식으로 대체가 가능한 이유는, 람다식도 실제로는 익명 객체이고,      
MyFunction 인터페이스를 구현한 익명 객체의 메서드 max()와 람다식의 매개변수의 타입과 개수 그리고 반환값이 일치하기 때문이다.

지금까지 살펴본 것처럼, 하나의 메서드가 선언된 인터페이스를 정의해서 람다식을 다루는 것은 기존 자바의 규칙들을 어기지 않으면서도      
자연스럽다. 그래서 인터페이스를 통해 람다식을 다루기로 결정되었으며, 람다식을 다루기 위한 인터페이스를      
'함수형 인터페이스(functional interface)'라고 부르기로 했다.
```java
   @Functionalinterface
   interface MyFunction{    //함수형 인터페이스 MyFunction을 정의
       public abstract int max(int a, int b);
   }
```
단, 함수형 인터페이스에는 오직 하나의 추상 메서드만 정의되어 있어야 한다는 제약이 있다. 그래야 람다식과 인터페이스의 메서드가   
1:1로 연결될 수 있기 때문이다. 반면에 static 메서드와 default 메서드의 개수에는 제약이 없다.    
※ @Functionalinterface를 붙이면, 컴파일러가 함수형 인터페이스를 올바르게 정의하였는지 확인해주므로, 꼭 붙이도록하자

기존에는 아래와 같이 인터페이스의 메서드 하느를 구현하는데도 복잡하게 해야 했는데,
```java
   List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");

   Collections.sort(list, new Comparator<String>(){
       public int compare(String s1, String s2){
           return s2.compareTo(s1);
       }
   });
```
이제 람다식으로 아래와 같이 간단히 처리할 수 있게 되었다.
```java
   List<String> list = Arrays.asList("abc", "aaa", "bbb", "ddd", "aaa");
   Collections.sort(list, (s1, s2) -> s2.compareTo(s1));
```       
### 함수형 인터페이스 타입의 매개변수와 반환타입
함수형 인터페이스 MyFunction이 아래와 같이 정의되어 있을 때,
```java
   @Functionalinterface
   interface MyFunction{
       void myMethod(int a, int b);     //추상메서드
   }
```
메서드의 매개변수가 MyFunction타입이면, 이 메서드를 호출할 때 람다식을 참조하는 참조변수를 매개변수로   
지정해야한다는 뜻이다.
```java
   void aMethod(MyFunction f){     //매개변수의 타입이 함수형 인터페이스
       f.myMethod();               //MyFunction에 정의된 메서드 호출
   }
   MyFunction f = () -> System.out.println("myMethod()");
   aMethod(f);
```
또는 참조변수 없이 아래와 같이 직접 람다식을 매개변수로 지정하는 것도 가능하다.
```java
   aMethod(() -> System.out.println("myMethod()"));
```
그리고 메서드의 반환타입이 함수형 인터페이스타입이라면, 이 함수형 인터페이스의 추상메서드와 동등한      
람다식을 가리키는 참조변수를 반환하거나 람다식을 직접 반환할 수 있다.
```java
   MyFunction myMethod{
       MyFunction f = () -> {};
       return f;                //이 줄과 윗 줄을 한 줄로 줄이면, return () -> {}
   }
```
람다식을 참조변수로 다룰 수 있다는 것은 메서드를 통해 람다식을 주고받을 수 있다는 것을 의미한다.        
즉, 변수처럼 메서드를 주고받는 것이 가능해진 것이다. 사실상 메서드가 아니라 객체를 주고받는 것이라      
근본적으로 달라진 것은 아무것도 없지만, 람다식 덕분에 예전보다 코드가 더 간결하고 이해하기 쉬워졌다.

## 1.4 java.util.function 패키지
자주 쓰이는 가장 기본적은 함수형 인터페이스
| 함수형 인터페이스 | 메서드 | 설명 |
|:----------|:----------:|----------:|
|java.lang.Runnable| <pre>void run()</pre> | 매개변수도 없고, 반환값도 없음.|
|Supplier<T>| <pre>T get() ▶ T</pre> | 매개변수도 없고, 반환값도 있음.|
|Consumer<T>| <pre>T ▶ void accept(T t)</pre> | Supplier와 반대로 매개변수만 있고,<br> 반환값이 없음.|
|Function<T, R>| <pre>T ▶ R apply(T t) ▶ R</pre> | 일반적인 함수. 하나의 매개변수를 받아서<br> 결과를 반환.|
|Predicate<T>| <pre>T ▶ boolean test(T t) ▶ boolean</pre> | 조건식을 표현하는데 사용됨.<br> 매개변수는 하나.반환 타입은 boolean.|

매개변수와 반환값의 유무에 따라 4개의 함수형 인터페이스가 정의되어 있고, Function의 변형으로 Predivate가 있는데,    
반환값이 boolean 이라는 것만 제외하면 Function과 동일하다. Predicate는 조건식을 함수로 표현하는데 사용된다.     
※참고 : 타입 문자 'T'는 'Type'을, 'R'은 Return Type'을 의미한다.  
수학에서 결과로 true 또는 false를 반환하는 함수를 '프레디케이트(predicate)'라고 한다.

### 매개변수가 두 개인 함수형 인터페이스
매개변수의 개수가 2개인 함수형 인터페이스는 이름 앞에 접두사 'Bi'가 붙는다      
※참고 : 매개변수가 타입으로 보통 'T'를 사용하므로, 알파벳에서 'T'의 다음 문자인 'U', 'V', 'W'를 매개변수의 타입으로 사용 하는 것일 뿐 별다른 의미는 없다.   
| 함수형 인터페이스 | 메서드 | 설명 |
|:----------|:----------:|----------:|
|BiConsumer<T, U>| <pre>T, U ▶ void accept(T t, U u)</pre> | 두개의 매개변수만 있고,<br> 반환값이 없음.|
|BiPredicate<T, U>| <pre>T, U ▶ boolean test(T t, U u) ▶ boolean</pre> | 조건식을 표현하는데 사용됨.<br> 매개변수는 둘.반환 타입은 boolean.|  
|BiFunction<T, U, R>| <pre>T, U ▶ R apply(T t, U u) ▶ R</pre> | 두개의 매개변수를 받아서<br> 하나의 결과를 반환.|

※참고 : Supplier는 매개변수는 없고 반환값만 존재하는데, 메서드는 두 개의 값을 반환할 수 없으므로 BiSupplier가 없는 것이다.

3개의 매개변수를 갖는 함수형 인터페이스를 선언한다면 다음과 같이 선언하여 사용한다.
```java
   @FunctionalInterface
   interface TriFunction<T,U,V,R>{
       R apply(T t, U u, V v)
   }
```

### UnaryOperator와 BinaryOperator
Function의 또 다른 변형으로 UnaryOperator와 BinaryOperator가 있는데, 매개변수의 타입과 반환타입의 타입이 모두 일치 한다는 점만      
제외하고는 Function과 같다.    
※참고 : UnaryOperator와 BinaryOperator의 조상은 각각 Function과 BiFunction 이다.
| 함수형 인터페이스 | 메서드 | 설명 |
|:----------|:----------:|----------:|
|UnaryOperator<T>| <pre>T ▶ T apply(T t ) ▶ T </pre> | Function의 자손, Function과 달리<br> 매개변수와 결과의 타입이 같다.|
|BinaryOperator<T, T>| <pre>T, T ▶ T apply(T t, T t ) ▶ T </pre> | BiFunction의 자손, BiFunction과 달리<br> 매개변수와 결과의 타입이 같다.|

### 컬렉션 프레임웍과 함수형 인터페이스
컬렉션 프레임웍의 인터페이스에 다수의 디폴트 메서드가 추가되었는데, 그 중의 일부는 함수형 인터페이스를 사용한다. 다음은 그 메서드들의 목록이다.         
※참고 : 단순화하기 위해 와일드 카드는 생략.     
| 인터페이스 | 메서드 | 설명 |
|:----------|:----------:|----------:|
|Collection | boolean removeIf(Predicate<E> filter)|조건에 맞는 요소를 삭제|
|List | void replaceAll(UnaryOperator<E> operator)|모든 요소를 변환하여 대체|
|Iterable|void forEach(Consumer<T> action)|모든 요소에 작업 action을 수행|
|Map|V compute(K key, BiFunction<K,V,V> f)|지정된 키의 값에 작업 f를 수행|
|Map|V computeIfAbsent(K key, Function<K,V> f)|키가 없으면, 작업 f를 수행 후 추가|
|Map|V computeIfPresent(K key, BiFunction<K,V,V> f)|지정된 키가 있을 때, 작업 f를 수행|
|Map|V merge(K key, BiFunction<K,V,V> f)|모든 요소에 병합작업 f를 수행|
|Map|V forEach(BiConsumer<K,V> action)|모든 요소에 작업 action을 수행|
|Map|V replaceAll(BiFunction<K,V,V> f)|모든 요소에 치환작업 f를 수행|

Map인터페이스에 있는 'compute'로 시작하는 메서드들은 맵의 value를 변환하는 일을 하고 merge()는 Map을 병합하는 일을 한다.

### 기본형을 사용하는 함수형 인터페이스
지금까지 소개한 함수형 인터페이는 매개변수와 반환값의 타입이 모두 지네릭 타입이었느넫, 기본형 타입의 값을 처리할 때도 래퍼(wrapper)클래스를 사용해 왔다.        
그러나 기본형 대신 래퍼클래스를 사용하는 것은 당연히 비효율적이다. 그래서 보다 효율적으로 처리할 수 있도록 기본형을 사용하는 함수형 인터페이스들이 제공된다.  
| 함수형 인터페이스 | 메서드 | 설명 |
|:----------|:----------:|----------:|
|DoubleToIntFunction|<pre>double ▶ int applyAsInt(double d) ▶ int </pre>| <b>A</b>To<b>B</b>Function은 입력이 A타입 출력이 B타입
|ToIntFunction<T>|<pre>T ▶ int applyAsInt(T value) ▶ int </pre>| To<b>B</b>Function은 출력이 B타입 입력이 제네릭 타입
|IntFunction<R>|<pre>int ▶ R apply(T t, U u) ▶ R </pre>| <b>A</b>Function은 입력이 A타입 출력이 제네릭 타입
|ObjIntConsumer<T>|<pre>T, int ▶ void accept(T t, U u)</pre>| Obj<b>A</b>Function은 입력이 T. A타입이고 출력은 없다.


