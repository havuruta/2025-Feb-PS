package problem;

/*
 문제 : 10845(스택)
 시간 : 460ms
 풀이 : 문제에서 요구하는 명령어에 맞는 스택 제공 메서드 활용.
 입력 형식에 맞는 조건문 분기 설정 및 스택이 비어있는 경우 고려가 필요.
 */

import java.util.Scanner;
import java.util.Stack;

public class B10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>();
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			
			char c = order.charAt(0);
			if (c == 'p') { // push, pop
				char c2 = order.charAt(1);
				
				if (c2 == 'u') { // push
					int val = sc.nextInt();
					st.push(val);
				}
				else { // pop
					if(st.empty()) System.out.println(-1);
					else System.out.println(st.pop());
				}
			}
			else if (c == 't') { // top
				if(st.empty()) System.out.println(-1);
				else System.out.println(st.peek());
			}
			else if (c == 's') { // size
				System.out.println(st.size());
			}
			else { // empty
				if(st.empty()) System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}
