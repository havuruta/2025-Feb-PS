package problem;
// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10845 {
    public static void main(String[] args) {
        // 문제 10845 해결을 위한 코드를 작성하세요.
    	Scanner sc = new Scanner(System.in);
		Queue<Integer> que = new LinkedList<>();
		int n = sc.nextInt(); // 명령어 수 입력
		sc.nextLine();//개행처리
		
		for (int i = 0; i < n; i++) { // 반복문 수정
			String str = sc.nextLine(); // 명령어 입력

			if (str.startsWith("push")) {
				int a = Integer.parseInt(str.split(" ")[1]); // 정수 추출
				que.add(a);
			} else if (str.equals("pop")) {
				if (que.isEmpty()) {//큐가 비어있는지 확인
					System.out.println(-1);
				} else {
					System.out.println(que.poll());//제일 앞의 값을 출력 후 제거
				}
			} else if (str.equals("front")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(que.peek());//제일 앞의 값을 출력만 제거x
				}
			} else if (str.equals("size")) {
				System.out.println(que.size());//큐의 크기 출력
			} else if (str.equals("empty")) {
				if (que.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (str.equals("back")) {
				if (que.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(((LinkedList<Integer>) que).getLast());//Queue에는 제일 뒤의 값만 출력이 안됨 그러므로 linkedlist의 getlast를 사용해서 출력
				}
			}
		}
    	
    }
}
