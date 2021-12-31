package ch14_lambda_stream;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class MM{ 
	/*메인함수*/ 
	public static void main(String[] args){  
		try{
			Robot robot = new Robot();
			
			for(int i = 0; i < 6000; i ++) {
				robot.mouseMove(500, 400);
				Thread.sleep(1000*60);
			}
			
		}catch(Exception exception) {
			System.out.println("실패");
		}
	}
}
