package youngjae;
// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class B10845 {
    public static void main(String[] args) {
        // 문제 10845 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Deque<Integer> que = new LinkedList<>();
		int num = 0;
		
		for (int i = 0; i < N; i++) {
			String order = sc.next();
			if (order.equals("push")) {
				num = sc.nextInt();
				que.addLast(num);
			} else if (order.equals("pop")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.removeFirst());
				}
			} else if (order.equals("front")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.getFirst());
				}
			} else if (order.equals("size")) {
				System.out.println(que.size());
			} else if (order.equals("empty")) {
				if (que.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (order.equals("back")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.getLast());
				}
			} 
			
			
			
			
			
		}
    }
}
