package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
public class B10828 {
    public static void main(String[] args) throws IOException {
        // 문제 10828 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int tc = Integer.parseInt(br.readLine());
    	Stack<Integer> stack = new Stack<>();
    	
    	for(int i = 0; i < tc; i++) {
    		//명령 입력받기
    		String order = br.readLine();
    		
    		//명령에 push포함시 나눈 후 숫자를 스택에 저장
    		if(order.contains("push")) {
    			String[] orders = order.split(" ");
    			stack.push(Integer.parseInt(orders[1]));
    			
    			//명령이 pop일 경우
    		} else if(order.equals("pop")) {
    			//스택이 비어있지 안을경우 pop, 비어있을경우 -1 출력
    			if(!stack.isEmpty()) {
    				System.out.println(stack.pop());
    			} else {
    				System.out.println(-1);
    			}
    			
    			//명령이 size일 경우 스택의 크기 출력
    		} else if(order.equals("size")) {
    			System.out.println(stack.size());
    			
    			//명령이 empty
    		} else if(order.equals("empty")) {
    			//비어있으면 1 아니면 0출력
    			if(stack.isEmpty()) {
    				System.out.println(1);
    			} else {
    				System.out.println(0);
    			}
    			
    			//명령이 top
    		} else if(order.equals("top")) {
    			//비어있지않으면 peek으로 출력 / 비어있으면 -1출력
    			if(!stack.isEmpty()) {
    				System.out.println(stack.peek());
    			} else {
    				System.out.println(-1);
    			}
    		}
    		
    	}
    	
    }
}
