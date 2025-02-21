package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
        
public class B2468 {
    
	//안전지대 탐색
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    
    static int N;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine());
        
        //지역의 높이 정보
        int[][] map = new int[N][N];
        
        //최대높이
        int maxHeight = 1;
        
        //지역 높이정보 입력 + 최대높이 찾기
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }
        
        
        int maxCount = 1;
        //최대 높이 -1 까지 반복하며 찾아볼 예정
        for(int k = 0; k < maxHeight; k++) {     
            
            // 방문처리 배열, 안전지대 배열, 두개는 있어야함
            visited = new boolean[N][N];
            int count = 0;
            
            //잠기지 않는 곳 true 처리 해야할듯
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] > k) {
                        visited[i][j] = true;
                    }
                }
            }
            

            //dfs로 방문 좌표 상하좌우 탐색후 true인곳 있으면 그곳으로 이동 후 false처리하고 
            //dfs재귀로 부르며 다 false로 만들기 전부 다 하면 count++ 하고 다음 true탐색하기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j]) {
                    	//맨처음 호출할때 구역 +1
                    	count++;
                        dfs(i, j);
                        
                    }
                }
            }
            
            maxCount = Math.max(maxCount, count);
            
        }
        bw.write(String.valueOf(maxCount));
        bw.flush();
        bw.close();
        br.close();
        
        
    }
    
    static void dfs(int i, int j) {
    	//방문처리 (안전한곳이 true에서 방문하면 false로)
    	visited[i][j] = false;
    	
    	
    	//상하좌우 탐색하면서 안간곳 방문처리
    	for(int k = 0; k < 4; k++) {
    		int nx = i + di[k];
    		int ny = j + dj[k];
    		
    		if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
    			continue;
    		}
    		if(visited[nx][ny]) {
    			dfs(nx, ny);
    		}
    	}
    	
    }
}