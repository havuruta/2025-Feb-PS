package problem;
// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
import java.util.Scanner;
import java.util.Stack;

public class B10828 {
    public static void main(String[] args) {
        // 문제 10828 해결을 위한 코드를 작성하세요.
    	
    	Scanner sc = new Scanner(System.in);
    	Stack<Integer> stack =new Stack<>();
    	int n =sc.nextInt();
    	sc.nextLine();
    	
    	for(int i =0;i<n; i++) {
    		String str = sc.nextLine();
    		if(str.startsWith("push")) {//push로 시작하면
    			int a = Integer.parseInt(str.split(" ")[1]);//제일 뒤의 숫자를 정수로 변환
    			stack.push(a);//stack a넣기
    		}else if(str.equals("top")) {
    			if (stack.empty())//스택이 비어있는지 확인
    				System.out.println(-1);
    			else
    			System.out.println(stack.peek());//스택의 제일 위의 값을 출력만 제거 x
    		}else if(str.equals("size")) {
    			System.out.println(stack.size());//스택의 크기
    		}else if(str.equals("empty")) {
    			if (stack.empty())//스택이 비어있는지
    				System.out.println(1);
    			else
    				System.out.println(0);
    		}else if(str.equals("pop")) {//스택의 제일 위의 값을 출력 후 제거
    			if (stack.empty())
    				System.out.println(-1);
    			else
    				System.out.println(stack.pop());
    		}
    	}
    }
}
