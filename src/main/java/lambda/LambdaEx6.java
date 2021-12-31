package lambda;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class LambdaEx6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntSupplier s = () -> (int)(Math.random()*100)+1;
		IntConsumer c = i -> System.out.print(i+", ");
		IntPredicate p = i -> i%2==0;
		IntUnaryOperator op = i -> i/10*10;	// i의 일의 자리를 없앤다.
		
		int[] arr = new int[10];
		
		makeRandomList(s, arr);
		System.out.println(Arrays.toString(arr));
		printEvenNum(p, c, arr);
		int[] newArr = doSomething(op, arr);
		System.out.println(Arrays.toString(newArr));
	}
	
	static int[] doSomething(IntUnaryOperator op, int[] arr){
		int[] newArr = new int[arr.length];
		
		for(int i=0; i < newArr.length; i++) {
			newArr[i] = op.applyAsInt(arr[i]); //apply()가 아님에 주
		}
		return newArr;
	}
	
	static <T> void printEvenNum(IntPredicate p, IntConsumer c, int[] arr) {
		System.out.print("[");
		for(int i : arr) {
			if(p.test(i)) {
				c.accept(i);
			}
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(IntSupplier s, int[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i] = s.getAsInt();	//get() 이 아니라 getAsInt()임에 주의 
		}
	}

}

/*
[77, 32, 50, 94, 87, 68, 37, 96, 93, 20]
[32, 50, 94, 68, 96, 20, ]
[70, 30, 50, 90, 80, 60, 30, 90, 90, 20]
 */
