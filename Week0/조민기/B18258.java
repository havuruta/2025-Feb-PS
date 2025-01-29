package Week0.조민기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class B18258 {

    static int[] arr = new int[2000000];
    static int front = 0;
    static int back = 0;
    static StringBuilder sb = new StringBuilder(); // 버퍼에 모아서 한 번에 출력

    public static void push(int x) {
        arr[back++] = x;
    }

    public static void pop() {
        if (back - front == 0) {
            sb.append("-1\n");
        } else {
            sb.append(arr[front++]).append("\n");
        }
    }

    public static void size() {
        sb.append(back - front).append("\n");
    }

    public static void empty() {
        sb.append((back - front == 0) ? "1\n" : "0\n");
    }

    public static void front() {
        if (back - front == 0) {
            sb.append("-1\n");
        } else {
            sb.append(arr[front]).append("\n");
        }
    }

    public static void back() {
        if (back - front == 0) {
            sb.append("-1\n");
        } else {
            sb.append(arr[back - 1]).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw   = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];

            switch (command) {
                case "push":
                    push(Integer.parseInt(commands[1]));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
