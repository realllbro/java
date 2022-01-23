package exception;

import java.io.File;

public class ExceptionEx16 {
    public static void main(String[] args)throws Exception{
        try {
            // command line 에서 입력받은 값을 이름으로 갖는 파일을 생성한다.
            File f = createFile(args[0]);
            System.out.println(f.getName() + " 파일이 성공적으로 생성되었습니다.");
        }catch (Exception e){
            System.out.println(e.getMessage()+" 다시 입력해 주시기 바랍니다.");
        }
    }

    static File createFile(String fileName)throws Exception{
        if(null == fileName || "".equals(fileName)) {
            throw new Exception("파일이름이 유효하지 않습니다.");
        }
        File f = new File(fileName);        // File 클래스의 객체를 만든다.
        f.createNewFile();                  // File 객체의 createNewFile 메서드를 이용해서 실제 파일을 생성한다.
        return f;
    }
}

/* 실행결과
    //파라메터 text.txt
    test2.txt 파일이 성공적으로 생성되었습니다.

    //파라메터 ""
    파일이름이 유효하지 않습니다. 다시 입력해 주시기 바랍니다.
 */
