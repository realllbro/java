## import java.io.FileInputStream;

1-1.바이트 기반 스트림
- InputStream, OutputStream

  |입출력대상 종류|입력스트림|출력스트림|
      |:----------|:----------|:----------|
  |파일|FileInputStream|FileOutStream|
  |메모리(byte배열)|ByteArrayInputStream|ByteArrayOutputStream|
  |프로세스(프로세스간의 통신)|PipedInputStream|PipedOutputStream|
  |오디오장치|AudioInputStream|AudioOutputStream|

    ```java
     InputStream
     abstract int read()	
     int read(byte[] b)
     int read(byte[] b, int off, int len)
     read()의 반환타입이 byte가 아니라 int인 이유는 read()의 반환값의 범위가 0~255와 -1이기 때문이다.
    
     OutputStream
     abstract void write(int b)
     void write(byte[] b)
     void write(byte[] b, int off, int len)
  
     InputStream Method
     
     int available() 
        => 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환한다.
        
     void close()
        => 스트림을 닫음으로써 사용하고 있던 자원을 반환한다.
     
     void mark(int readlimit)
        => 현재위치를 표시해 놓는다. 후에 reset()에 의해서 표시해 놓은 위치로 다시 돌아갈 수 있다 . readlimit은 되돌아갈 수 있는 byte의 수이다.
     
     boolean markSupported()
        => mark()와 reset()을 지원하는지를 알려 준다. mark()와 reset()기능을 지원하는 것은 선택적이므로, mark()와 reset()을 사용하기 전에 markSupported()를 호출해서 지원여부를 확인해야 한다.
        
     abstract int read() 1byte를 읽어 온다(0~255사이의값).더 이상 읽어 올 데이터가 없으면 -1을 반환한다. abstract메서드라서 InputStream의 자손들은 자신의 상황에 알맞게 구현해야 한다. 
     
     int read(byte[] b)
        => 배열 b의 크기만큼 읽어서 배열을 채우고 읽어 온 데이터의 수를 반환한다. 반환하는 값은 항상 배열의 크기보다 작거나 같다.
        
     int read(byte[] b, int off, int len)
        => 최대 len개의 byte를 읽어서, 배열 b의 지정된 위치(off)부터 저장한다. 실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.
     
     void reset()
        => 스트림에서의 위치를 마지막으로 mark()이 호출되었던 위치로 되돌린다.
     
     logn skip(long n)
        => 스트림에서 주어진 길이(n) 만큼을 건너뛴다.
     ※ 스트림의 종류에 따라서 mark()와 reset()을 사용하여 이미 읽은 데이터를 되돌려서 다시 읽을 수 있다. 이 기능을 지원하는 스트림인지 확인하는 markSuppoprted()를 통해서 알 수 있다
        
     OutputStream Method
     void close()
        => 입력소스를 닫음으로써 사용하고 있던 자원을 반환한다.
        
     void flush()
        => 스트림의 버퍼에 있는 모든 내용을 출력소스에 쓴다.
        
     abstract void write(int b)
        => 주어진 값을 출력소스에 쓴다.
        
     void write(byte[] b)
        => 주어진 배열 b에 저장된 모든 내용을 출력소스에 쓴다.
        
     void write(byte[] b, int off, int len) 
        => 주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서 출력소스에 쓴다.
        
     ※ flush()는 버퍼가 있는 출력스트림의 경우에만 의미가 있으며, OutputStream에 정의된 flush()는 아무런 일도 하지 않는다.
     
     프로그램이 종료될 때, 사용하고 닫지 않은 스트림을 JVM이 자동적으로 닫아 주기는 하지만, 스트림을 사용해서 모든 작업을 
     마치고 난 후에는 close()를 호출해서 반드시 닫아 주어야 한다. 그러나 ByteArrayInputStream과 같이 메모리를 사용하는 스트림과 System.in, System.out과 같은 표준 입출력 스트림은 닫아 주지 않아도 된다.

    ```

1-2.바이트 기반 보조스트림
- 보조스트림은 실제 데이터를 주고받는 스트림이 아니기 때문에 데이터를 입출력할 수 있는 기능은 없지만,    
  스트림의 기능을 향상시키거나 새로운 기능을 추가할 수 있다. 그래서 보조 스트림만으로는 입출력을 처리할 수 없고,      
  스트림을 먼저 생성한 다음에 이를 이용해서 보조스트림을 생성해야 한다.

    ```java
    // 먼저 기반스트림을 생성한다. 
    FileInputStream fis = new FileInputStream("text.txt");
    
    // 기반스트림을 이용해서 보조스트림을 생성한다.
    BufferedInputStream bis = new BufferedInputStream(fis);
    
    // 보조스트림인 BufferedInputStream 으로부터 데이터를 읽는다.
    bis.read();
    
    // 코드 상으로는 보조스트림인 BufferedInputStream이 입력기능을 수행하는 것처럼 보이지만,
    // 실제 입력기능은 BufferedInputStream과 연결된 FileInputStream이 수행하고, 
    // 보조스트림 BufferedInputStream은 버퍼만을 제공한다.
    // 버퍼를 이용하는 유무에 따라 성능 차이가 상당해서 대부분 버퍼를 이용한 보조스트림을 사용한다.
    ```

  |입력|출력|설명|
      |:----------|:----------|:----------|
  |FilterInputStream|FilterOutputStream|필터를 이용한 입출력 처리|
  |BufferedInputStream|BufferedOutputStream|버퍼를 이용한 입출력 성능향상|
  |DataInputStream|DataOutputStream|int, float와 같은 기본형 단위(primitive type)로 데이터를 처리하는 기능|
  |SequenceInputStream|없음|두 개의 스트림을 하나로 연결|
  |LineNumberInputStream|없음|읽어 온 데이터의 라인 번호를 카운트 (JDK1.1 부터 LineNumberreader로 대체)|
  |ObjectInputStream|ObjectOutputStream|데이터를 객체단위로 읽고 쓰는데 사용.<br/> 주로 파일을 이용하며 객체 직렬화와 관련있음|
  |없음|PrintStream|버퍼를 이용하며, 추가적인 print관련 기능(print, printf, println메서드)|
  |PushbackInputStream|없음|버퍼를 이용해서 읽어 온 데이터를 다시 되돌리는 기능 <br/>(unread, push back to buffer)|


2-1.문자기반스트림
- Reader, Writer
- 바이트 기반의 스트림은 입출력 단위가 1byte라는 뜻이다.   
  java에서는 한 문자를 의미하는 char형이 1byte가 아니라 2byte이기 때문에 바이트 기반의 스트림으로  
  2byte인 문자를 처리하는 데는 어려움이 있다. 이점을 보완하기 위해서 문자기반의 스트림이 제공된다.   
  문자 데이터를 입출력할 때는 바이트 기반 스트림 대신 문자기반 스트림을 사용하자.

  |바이트기반 스트림|-|문자기반 스트림|
      |:----------|:----------|:----------|
  |inputStream|ㅡ>|Reader|
  |OUputStream|ㅡ>|Writer|
  |FileInputStream|ㅡ>|FileReader|
  |FileOutputStream|ㅡ>|FileWriter|
  |ByteArrayInputStream|ㅡ>|CharArrayReader|
  |ByteArrayOutputStream|ㅡ>|CharArrayWriter|
  |PipedInputStream|ㅡ>|PipedReaer|
  |PipedOutputStream|ㅡ>|PipedWriter|
  |StringBufferInputStream (deprecated)|ㅡ>|StringReader|
  |StringBufferOutputStream (deprecated)|ㅡ>|StringWriter|

  ※StringBufferInputStream, StringBufferOutputStream 은 StringReader와 StringWriter로 대체되어 더 이상 사용되지 않는다.

   ```java
   Method IuputStream -> Reader
   abstract int read() -> int read()
   int read(byte[] b) -> int read(char[] cbuf)
   int read(byte[] b, int off, int len) -> abstract int read(char[] cbuf, int off, int len)
   
   Method OutputStream -> Writer
   abstract void write(int b) -> void write(int c)
   void write(byte[] b) -> void write(char[] cbuf)
   void write(byte[] b, int off, int len) -> abstract void write(char[] cbuf, int off, int len)
                                             void write(String str)
                                             void write(String str, int off, int len)
   ```
2-2.문자기반 보조스트림

|바이트기반 보조 스트림|-|문자기반 보조 스트림|
|:----------|:----------|:----------|
|BufferedInputStream|ㅡ>|BufferedReader|
|BufferedOutputStream|ㅡ>|BufferedWriter|
|FilterInputStream|ㅡ>|FilterReader|
|FilterOutputStream|ㅡ>|FilterWriter|
|LineNumberInputStream(deprecated)|ㅡ>|LineNumberReader|
|PrintStream|ㅡ>|PrintWriter|
|PushbackInputStream|ㅡ>|PushbackReader|

