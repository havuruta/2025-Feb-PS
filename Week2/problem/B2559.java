package problem;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class B2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        int[] temper = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            temper[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n - k; i++) {//전체 길이에서 -(k+1)만큼 가도록
            int sum = 0;
            for (int j = 0; j < k; j++) {//해당 i의 위치 포함해서 k만큼 누적
                sum += temper[i + j]; 
            }
            max = Math.max(max, sum);//최댓값 갱신
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}