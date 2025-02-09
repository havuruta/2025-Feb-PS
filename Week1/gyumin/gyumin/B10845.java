package gyumin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
public class B10845 {
	public static void main(String[] args) throws IOException {
		// 문제 10845 해결을 위한 코드를 작성하세요.
		
		// ArrayDeque로 Deque 구현
		Deque<Integer> queue = new ArrayDeque<>();
		
		// 명령 받아올 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 들어올 명령 수
		int T = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < T; i++) {
			
			// 명령 가져오기
			String input = br.readLine();
			
			// push 명령을 구분하기 위해 분할
			String [] in = input.split(" ");
			
			// 들어온 입력에 따라 deque 메서드 실행
			switch(in[0]){
			case "push":
				queue.add(Integer.parseInt(in[1]));
				break;
			case "pop":
				if (queue.size() == 0) {
					System.out.println(-1);
				} else {
					System.out.println(queue.pop());
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if (queue.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.getFirst());
				}
				break;
			case "back":
				if (queue.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(queue.getLast());
				}
				break;
			}
		}
		
		br.close();

	}
}
