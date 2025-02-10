package nayoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B10845 {
    public static void main(String[] args) throws IOException {
        // 문제 10845 해결을 위한 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>(); // 큐로 LinkedList 사용

        int n = Integer.parseInt(br.readLine()); // 명령의 수 n
        StringTokenizer st;  // StringTokenizer는 공백 기준으로 빠르게 데이터를 분리해준다.

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();  // 명령어 읽기

            switch(command) {
                case "push":
                    int x = Integer.parseInt(st.nextToken()); // 'push' 명령어 뒤의 값을 읽어오고 int형으로 변환
                    queue.addLast(x);  // 큐의 뒤에 값 추가
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.pollFirst());  // 비어있지 않다면 큐의 맨 앞에서 값 제거 후 반환
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.getFirst());  // 비어있지 않다면 큐의 맨 앞 값 출력
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.getLast());  // 비어있지 않다면 큐의 맨 뒤 값 출력
                    }
                    break;
            }
        }
    }
}
