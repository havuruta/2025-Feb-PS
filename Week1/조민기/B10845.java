package 조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
public class B10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque();
        StringBuilder sb = new StringBuilder();
        
        for (int n = 0; n<N; n++){
            String[] now = br.readLine().split(" ");
            switch (now[0]) {
                case "pop":
                    sb.append((deque.isEmpty() ? -1 : deque.pollFirst())).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append((deque.isEmpty() ? 1 : 0)).append("\n");
                    break;
                case "front":
                    sb.append((deque.isEmpty() ? -1 : deque.peekFirst())).append("\n");
                    break;
                case "back":
                    sb.append((deque.isEmpty() ? -1 : deque.peekLast())).append("\n");
                    break;
                default:
                    deque.offerLast(Integer.parseInt(now[1]));
                    break;
            } 
        }
        System.out.println(sb.toString());
    }
}