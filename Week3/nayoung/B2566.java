package Week3.nayoung;

import java.io.IOException;
import java.util.Scanner;

public class B2566 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //최대값

        int[][] arr = new int[9][9]; //9x9 배열 (0행, 0열부터 시작)
        int max = Integer.MIN_VALUE; //최대값
        int maxcol = -1; //max=0으로 초기화한 상태에서 모든 값이 0일 때, maxcol, maxrow 1로 초기화해둬야지 1행1열이 나온다
        int maxrow = -1; //(주어지는 수는 100보다 작은 자연수 또는 0이기 때문. 최대값 초기화는 해당 자료형의 최소값으로 하는게 가장 안전!!! 이렇게 연습하자!!!)
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                arr[r][c] = sc.nextInt();  //배열값 입력

                //입력받으면서 최대값 및 그때의 인덱스 바로바로 갱신
                if(arr[r][c]>max){
                    max = arr[r][c];
                    maxrow = r+1; //0행부터 시작이므로 문제에 맞게 +1해줘야 함
                    maxcol = c+1; //0열부터 시작이므로 문제에 맞게 +1해줘야 함
                }
            }

        }

        System.out.println(max);
        System.out.println(maxrow+" "+maxcol);

        sc.close();
    }//main끝
}
