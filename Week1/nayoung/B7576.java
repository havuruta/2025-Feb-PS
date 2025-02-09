package nayoung;
// B7576.java - 미해결
// 문제 7576: 토마토 - BFS를 이용하여 토마토가 모두 익는 최소 일수 계산.
/*
1) 0이 없는 경우: -1 또는 1로만 이루어짐(1은 최소 1개). 즉 저장될 때부터 모든 토마토가 익어있는 상태이므로 0 출력.
- 0이 있을 때 cnt++해서 최종 cnt가 0이면 된다.
2) "값이 0"인 칸의 상하좌우가 -1로 모두 막힌 경우(가장자리도 고려): 토마토가 모두 익지 못하므로 -1 출력.
2-1) 가장자리에 -1이 2개 이상 있고, 그 사이에 0이 하나라도 있는 경우: 토마토가 모두 익지 못하므로 -1 출력.
3) 1이 가장자리에만 있는 경우: 가장자리에서 인접해 있는 0의 최대 개수 출력.(가로, 세로 한번씩만 생각)
4) 1이 내부에 있는 경우: 그 1을 새로운 가장자리로 생각하고 그때의 가장 큰 직사각형 내에서 가장자리에서 인접해 있는 0의 최대 개수 출력.(가로, 세로 한번씩만 생각)
 */
import java.util.Arrays;
import java.util.Scanner;

public class B7576 {
    public static void main(String[] args) {
        // 문제 7576 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 가로 칸의 수(열 개수)
        int n = sc.nextInt(); // 세로 칸의 수(행 개수)
        int[][] arr = new int[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j]==0){cnt++;}
            }
        }
        //System.out.println(Arrays.deepToString(arr)); //확인용 출력 - 이후 주석 처리

        if(cnt==0){
            System.out.println(0);
        }else{

        }


    }
}
