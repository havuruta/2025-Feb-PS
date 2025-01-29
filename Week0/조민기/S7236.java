package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S7236 {
    static int[][] pattern = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 항상 성립하는 케이스를 고려해보기
        for (int t = 1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] water = new int[N][N];
            for (int i = 0; i<N; i++){
                water[i] = Arrays.stream(br.readLine().split(" "))  // 공백 기준으로 문자열 배열 생성
                                    .mapToInt(s -> "W".equals(s) ? 8 : "G".equals(s) ? -1 : 0)  // 변환 조건
                                    .toArray();
            }
            int depth = 1;
            for (int i = 1; i<N-1; i++){
                for (int j = 1; j<N-1; j++){
                    if (water[i][j]>0){
                        for (int[] p: pattern){
                            int ni = i+p[0];
                            int nj = j+p[1];
                            if (ni>=0 && nj>=0 && ni<N && nj<N && water[ni][nj]<0){
                                water[i][j]--;
                            }
                        }
                        if (water[i][j]==0){
                            continue;
                        } else depth = Math.max(depth, water[i][j]);
                    } else continue;
                }
            }
            
            System.out.println("#"+t+" "+depth);
        }
        
    }
}
