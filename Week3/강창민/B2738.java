package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2738 {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
     	
    	// N*M배열 
     	int N = Integer.parseInt(st.nextToken());
     	int M = Integer.parseInt(st.nextToken());
    	
     	int[][] arr1 = new int[N][M];
     	int[][] arr2 = new int[N][M];
     	
     	//각 배열 입력받기 
     	for(int i = 0; i < N; i++) {
     		st = new StringTokenizer(br.readLine());
     		for(int j = 0; j < M; j++) {
     			arr1[i][j] = Integer.parseInt(st.nextToken());
     		}
     	}
     	
     	for(int i = 0; i < N; i++) {
     		st = new StringTokenizer(br.readLine());
     		for(int j = 0; j < M; j++) {
     			arr2[i][j] = Integer.parseInt(st.nextToken());
     		}
     	}
     	
     	//합 배열 안만들어도 사실 아무문제 없음
     	int[][] arrSum = new int[N][M];
     	
     	for(int i = 0; i < N; i++) {
     		for(int j = 0; j < M; j++) {
     			arrSum[i][j] = arr1[i][j] + arr2[i][j];
     			bw.write(arrSum[i][j] + " ");
     		}
     		bw.write("\n");
     	}

     	bw.flush();
     	bw.close();
     	br.close();
    }
}
