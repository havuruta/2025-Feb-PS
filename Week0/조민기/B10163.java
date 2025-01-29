package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B10163 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] color = new int[N][];
        for (int i = 0; i<N; i++){
            int[] now = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            color[i] = now;
        }

        int[] res = new int[N];
        boolean[][] map = new boolean[1001][1001];
        for (int i = N-1; i>=0; i--){
            int temp = 0;
            for (int y = color[i][1]; y<color[i][1]+color[i][3]; y++){
                for (int x = color[i][0]; x<color[i][0]+color[i][2]; x++){
                    if (!map[y][x]){
                        map[y][x] = true;
                        temp++;
                    }
                }
            }
            res[i] = temp;
        }
        for (int i = 0; i<N; i++){
            System.out.println(res[i]);
        }
    }
}
