# Java File

---
## method
```java
File(String fileName)
=> 주어진 문자열(fileName)을 이름으로 갖는 파일을 위한 File인스턴스를 생성한다. 
   파일 뿐만 아니라 디렉토리도 같은 방법으로 다룬다.
   여기서 fileName은 주로 경로(path)를 포함해서 지정해 주지만, 
   파일 이름만 사용해도 되는 데 이 경우 프로그램이 실행되는 위차가 경로(path)로 간주된다

File(String pathName, String fileNmae) 
File(File pathName, String fileNmae) 	  
=> 파일의 경로와 이름을 따로 분리해서 지정할 수 있도록 한 생성자.
   이 중 두번째 것은 경로를 문자열이 아닌 File 인스턴스인 경우를 위해서 제공된 것이다
   
File(URI uri)
=> 지정된 uri로 파일을 생성

String getName()
=> 파일이름을 String으로 반환

String getPath()
=> 파일의 경로(path)를 String으로 반환

String getAbsolutePath()
=> 파일의 절대경로를 String으로 반환

File etAbsoluteFile()
=> 파일의 절대경로를 File로 반환

String getParent()	  	
=> 파일의 조상 디렉토리를 String으로 반환

File getParentFile()
=> 파일의 조상 디텍토리를 File로 반환

String getCanonicalPath()
=> 파일의 정규경로를 String으로 반환

File getCanonicalFile()
=> 파일의 정규경로를 File으로 반환	  	

static String pathSeparator
=> OS에서 사용하는 경로(path) 구분자. 윈도우";", 유닉스":"

static char pathSeparatorChar
=> OS에서 사용하는 경로(path) 구분자. 윈도우";", 유닉스":"	  

static String separator
=> OS에서 사용하는 경로(path) 구분자. 윈도우"\", 유닉스"/"

static char separatorChar
=> OS에서 사용하는 경로(path) 구분자. 윈도우"\", 유닉스"/"	  	  	

※ 참고 : 파일의 경로(path)와 디렉토리나 파일의 이름을 구분하는 데 사용 되는 구분자가 OS마다 다를 수 있기 때문에,
OS독립적으로 프로그램을 작성하기 위해서는 반드시 위의 멤버변수들을 이용해야 한다. 만일 윈도우에서 사용하는 구분자를
코드에 직접 적어 놓았다면, 이 코드는 다른 OS에서는 오류를 일으킬 수 있다.

boolean canRead()
=> 읽을 수 있는 파일인지 검사한다.

boolean canWrite()
=> 쓸 수 있는 파일인지 검사한다.

boolean canExecute()
=> 실행할 수 있는 파일인지 검사한다.

int compareTo(File pathname)
=> 주어진 파일 또는 디렉토리를 비교한다. 같으면 0을 반환하며, 다르면 1또는 -1을 반환한다.
(Unix 시스템에서는 대소문자를 구별하며, Windows에서는 구별하지 않는다.)

boolean exists()
=> 파일이 존재하는지 검사한다.

boolean isAbsolute()
=> 파일 또는 디렉토리가 절대경로명으로 지정되었는지 확인한다.

boolean isDirectory()
=> 디렉토리인지 확인하다.

boolean isFile()
=> 파일인지 확인하다.

boolean isHidden()
=> 파일의 속성이 숨김(Hidden)인지 확인한다. 또한 파일이 존재하지 않으면 false를 반환한다.

boolean createNewFile()
=> 아무런 내용이 없는 새로운 파일을 생성한다.(단, 생성하려는 파일이 이미 존재하면 생성되지 않는다.)

static File createTempFile(String prefix, String suffix)
=> 임시파일을 시스템의 임시 디렉토리에 생성한다.
System.out.println(File.createTempFile("work",".tmp"))
결과 c:\ .....

static File createTempFile(String prefix, String suffix, File directory)
=> 임시 파일을 시스템의 지정된 디렉토리에 생성한다.

boolean delete()
=> 파일을 삭제한다.

void deleteOnExit()
=> 응용 프로그램 종료시 파일을 삭제한다. 주로 실행 시 작업에 사용된 임시파일을 삭제하는데 사용된다.

boolean equals(Object obj)
=> 주어진 객체(주로 File인스턴스)가 같은 파일인지 비교한다.
(UNIX 시스템에서는 대소문자를 구별하며, Windows에서는 구별하지 않는다.)

long lastModified()
=> 파일의 마지막으로 수정된 시간을 지정된 시간을 반환

long length()
=> 파일의 크기를 반환한다.

String[] list()
=> 디렉토리의 파일목록(디렉토리 포함)을 String 배열로 반환한다.

String[] list(FilenameFilter filter)
=> FilenameFilter 인스턴스에 구현된 조건에 맞는 파일을 String배열 로 반환한다.

File[] list(FilenameFilter filter)
=> FilenameFilter 인스턴스에 구현된 조건에 맞는 파일을 File배열 로 반환한다.

File[] listFiles()
=> 디렉토리의 파일목록(디렉토리 포함)을 File 배열로 반환

File[] listFiles(FileFilter filter)
=> 디렉토리의 파일목록(디렉토리 포함)을 filter의 조건과 일치하는 파일만 File 배열로 반환

File[] listFiles(FilenameFilter f)
=> 디렉토리의 파일목록(디렉토리 포함)을 filter의 조건과 일치하는 파일만 File 배열로 반환

static File[] listRoots()
=> 컴퓨터의 파일시스템의 root의 목록(floppy, CD-ROM, HDD drive)을 반환(예:A:\, C:\, D:\)

long getFreeSpace()
=> File이 root 일때, 비어있는 공간을 바이트 단위로 반환

long getTotalSpace()
=> File이 root 일때, 전체 공간을 바이트 단위로 반환

long getUsableSpace()
=> File이 root 일때, 사용가능한 공간을 바이트 단위로 반환

boolean mkdir()
=> 파일에 지정된 경로로 디렉토리(폴더)를 생성, 성공하면 true

boolean mkdirs()
=> 파일에 지정된 경로로 디렉토리(폴더)를 생성, 성공하면 true
필요하면 부모 디렉토리까지 생성

boolean renameTo(File dest)
=> 지정된 파일(dest)로 이름을 변경

boolean setExecutable(boolean executable)
boolean setExecutable(boolean executable, boolean ownerOnly)
boolean setReadable(boolean readable)
boolean setReadable(boolean readable, boolean ownerOnly)
boolean setReadOnly()
boolean setWritable(boolean writable)
boolean setWritable(boolean writable, boolean ownerOnly)
=> 파일의 속성을 변경한다. ownerOnly가 true면, 파일의 소유자만 해당 속성을 변경할 수 있다.

boolean setLastModified(long f)
=> 파일의 마지막으로 수정된 시간을 지정된(t)으로 변경

Path toPath()
=> 파일을 Path로 변환해서 반환

URI toURI()
=> 파일을 URI로 변환해서 반환
```
