package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1220 {
    static final int SIZE = 100;
    
    // <> 꺽쇠 문제랑 같음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t = 1; t <= 10; t++) { // 10개의 테스트 케이스
            br.readLine();
            int[][] table = new int[SIZE][SIZE];

            for (int i = 0; i < SIZE; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < SIZE; j++) {
                    table[i][j] = Integer.parseInt(line[j]);
                }
            }

            int result = countDeadlocks(table);
            System.out.println("#" + t + " " + result);
        }
    }

    static int countDeadlocks(int[][] table) {
        int count = 0;

        for (int j = 0; j < SIZE; j++) { // 열 단위로 탐색
            boolean hasN = false; // N극(1)을 찾았는지 여부
            
            for (int i = 0; i < SIZE; i++) {
                if (table[i][j] == 1) { // N극(1) 발견 -> 시작 신호
                    hasN = true;
                } 
                else if (table[i][j] == 2 && hasN) { // S극(2) 발견 & 이전에 N극(1)이 있었다면 교착 상태 발생
                    count++;
                    hasN = false; // 새로운 교착 상태를 찾기 위해 초기화
                }
            }
        }
        return count;
    }
}
