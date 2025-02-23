package Week3.nayoung;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B10798 {
    public static void main(String[] args) throws IOException {
        //세로읽기
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[5][15]; //최대 15개의 글자이므로 최대길이로 설정

        //입력
        for(int i=0;i<5;i++){
            String tmp = sc.next(); //문자열 입력받음
            for(int j=0;j<tmp.length();j++){ //입력받은 문자열의 문자를 하나씩 집어넣음
                arr[i][j] = tmp.charAt(j); //
            }
        }

        for(int c=0;c<15;c++){ //열고정
            for(int r=0;r<5;r++){ //행순회
                if(arr[r][c]!='\0'){ //값이 기본값인 null이면 입력되지 않은 것이므로 출력하지 않음
                    System.out.print(arr[r][c]);
                }
            }
        }

    }
}
