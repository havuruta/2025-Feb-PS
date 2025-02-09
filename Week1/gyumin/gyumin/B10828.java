package gyumin;

import java.util.Scanner;

// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
public class B10828 {
	
	private static final int MAX_SIZE = 10000;
	private int [] stack = new int [MAX_SIZE];
	private int size = 0;
	private int top = -1;
	
    public static void main(String[] args) {
        // 문제 10828 해결을 위한 코드를 작성하세요.
    	
    	// String.split(" ") -> 공백을 기준으로 스트링 자르기 => push 명령어 처리에 필요
    	B10828 stack = new B10828();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int lines = sc.nextInt();
    	
    	// 입력에 따른 메서드 실행
    	for(int i = 0; i <= lines; i++) {
    		String input = sc.nextLine();
    		if(input.contains("push")) {
    			stack.push(Integer.parseInt(input.split(" ")[1]));
    		} else if(input.equals("pop")) {
    			stack.pop();
    		} else if(input.equals("size")) {
    			stack.size();
    		} else if (input.equals("empty")) {
    			stack.empty();
    		} else if (input.equals("top")) {
    			stack.top();
    		}
    	}
    	
    }
    
    // push()
    // 스택의 크기 이상 입력이 들어오는 스택 오버플로우 처리 필요
    void push(int x) {
    	if(size == MAX_SIZE) {
    		System.out.println("스택 오버플로우 발생");
    	} else {
    	top++;
		stack[top] = x;
		size++;
    	}
	}
	
    // pop()
    // 스택의 크기 이상 출력이 나가는 스택 언더플로우 처리 필요(이건 문제에서도 요구함)
	void pop() {
		if(size == 0) {
			System.out.println(-1);
		} else {
		int temp = stack[top];
		stack[top--] = 0;
		size--;
		System.out.println(temp);
		}
	}
	
	void size() {
		System.out.println(size);
	}
	
	void empty() {
		if(size == 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	
	void top() {
		if(top > -1) {
			System.out.println(stack[top]);
		} else {
			System.out.println(-1);
		}
	}
    
}
