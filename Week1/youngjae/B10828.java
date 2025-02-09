package youngjae;
// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
import java.util.Scanner;
import java.util.Stack;
public class B10828 {
    public static void main(String[] args) {
        // 문제 10828 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			// 1. 문자열을 받는다.
			String order = sc.next();
			if (order.equals("push")) {
				num = sc.nextInt();
				stack.push(num);
			} else if (order.equals("top")) {
				if (stack.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				
			} else if (order.equals("size")) {
				System.out.println(stack.size());
			} else if (order.equals("empty")) {
				if (stack.size() == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (order.equals("pop")) {
				if (stack.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				
			}
		}
    }
}
