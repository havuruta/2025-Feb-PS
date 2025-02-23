package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2667 {
	//탐색용
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = {0, 0, -1, 1};

	static int N; //지도의 크기 
	static boolean[][] visited; //체크용 배
	static List<Integer> sede = new ArrayList<>(); //단지별 몇세대 
	static int just = 0; //단지
	static int count = 0; //몇세대인지 세기 
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		N = Integer.parseInt(br.readLine());
		//크기 입력받고 초기화
		int[][] map = new int[N][N];
		visited = new boolean[N][N];
		
		//집유무 입력 + 방문처리 배열까지 입력받
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
				//집이 있는곳은 true
				if(map[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) {
					just++; //(단지수 ++)
					count = 0; //단지에 있는 세대 초기화)
					dfs(i, j);
					sede.add(count); //탐색후 세대수 추가
				}
			}
		}
		//오름차순 정렬
		Collections.sort(sede);
		
		bw.write(String.valueOf(just) + "\n");
		for(int i = 0; i < sede.size(); i++) {
			bw.write(String.valueOf(sede.get(i)) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = false; //방문한집은 false
		count++; //세대수 ++
		
		//상하좌우 탐색
		for(int i = 0; i < 4; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			//방문안한(true)면 탐색
			if(visited[nx][ny]) {
				dfs(nx, ny);
			}
			
		}
	}
}
