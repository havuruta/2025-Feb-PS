package 조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// B10828.java
// 문제 10828: 스택 - 정수를 저장하는 스택의 다양한 연산 구현.
public class B10828 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int n = 0; n<N; n++){
            String[] now = br.readLine().split(" ");
            switch (now[0]) {
                case "pop":
                    sb.append((stack.isEmpty() ? -1 : stack.pop())).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append((stack.isEmpty() ? 1 : 0)).append("\n");
                    break;
                case "top":
                    sb.append((stack.isEmpty() ? -1 : stack.peek())).append("\n");
                    break;
                default:
                    stack.add(Integer.parseInt(now[1]));
                    break;
            } 
        }
        System.out.println(sb.toString());
    }
}
