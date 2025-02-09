package jaesung;

/*
 문제 : 10845 (큐)
 시간 : 460ms
 풀이 : 문제에서 요구하는 명령어 맞는 큐 제공 메서드를 사용.
 문제 입력 형식에 맞는 분기 구성 및 큐가 비어있는 상황 고려가 필요.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class B10845 {
    public static void main(String[] args) {
        		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue<Integer> q = new LinkedList<>();
		
		int back = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			char c = str.charAt(0);
			
			if (c == 'p') { // push, pop				
				if (str.charAt(1) == 'u') { // push
					back = sc.nextInt();
					q.add(back);
				}
				else { // pop
					if (q.isEmpty()) System.out.println(-1);
					else System.out.println(q.poll());
				}
			}
			else if (c == 'f') { // front
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(q.peek());
			}
			else if (c == 'b') { // back
				if (q.isEmpty()) System.out.println(-1);
				else System.out.println(back);
			}
			else if (c == 's') { // size
				System.out.println(q.size());
			}
			else { // empty
				if (q.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
		}
	}
}