package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
public class B1546 {
    public static void main(String[] args) throws IOException {
        // 문제 1546 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	//점수 개수
    	int scoreCount = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	//점수 배열
    	int[] scores = new int[scoreCount];
    	
    	//최대 점수
    	int maxScore = 0;
    	
    	//시험점수 , 최대점수 구하기
    	for(int i = 0; i < scoreCount; i++) {
    		scores[i] = Integer.parseInt(st.nextToken());
    		if(scores[i] > maxScore) {
    			maxScore = scores[i];
    		}
    	}
    	
    	//조작한 점수 배열
    	double[] newScores = new double[scoreCount];
    	
    	//조작한 점수의 합
    	double sum = 0;
    	
    	//새로운 점수로 변환 , 점수합
    	for(int i = 0; i < scoreCount; i++) {
    		newScores[i] = (double) scores[i]/maxScore * 100;
    		sum += newScores[i];
    	}
    	
    	// 조작점수 평균
    	double avg = sum / scoreCount;
    	
    	System.out.println(avg);
    	
    	
    	
    }
}
