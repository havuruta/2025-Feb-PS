package hyochang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B6064 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()); // x는 m 주기
            int y = Integer.parseInt(st.nextToken()); // y는 n 주기

            int lcm = lcm(m, n);//최소 공배수를 구함
            boolean found = false;

            for (int k = 0; k * m + x <= lcm; k++) {//멸망하기 전까지
                int year = k * m + x; // 현재 연도

                if ((year - 1) % n + 1 == y) {// year를 n으로 나눈 나머지가 y와 같은지 확인 같으면 종료
                    sb.append(year).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found)
                sb.append(-1).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}
