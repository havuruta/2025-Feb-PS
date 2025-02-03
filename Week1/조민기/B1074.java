package 조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// B1074.java
// 문제 1074: Z - Z 모양으로 배열을 탐색하여 특정 위치 계산.
public class B1074 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int res = 0;
        double temp = Math.pow(2, N)/2;

        while (temp >= 2) {
            if (r>=temp && c>=temp){
                res+=(temp*temp*3);
                r-=temp;
                c-=temp;
            } else if (r>=temp && c<temp){
                res+=(temp*temp*2);
                r-=temp;
            } else if (r<temp && c>=temp){
                res+=(temp*temp*1);
                c-=temp;
            }
            temp/=2;
        }

        if (r==0 && c==0){
            res+=1;
        } else if (r==0 && c==1){
            res+=2;
        } else if (r==1 && c==0){
            res+=3;
        } else {
            res+=4;
        }

        System.out.println(res-1);
    }

    // 오히려 재귀보다 반복문이 빠르게 나옴
    // public static int findZ(int n, int r, int c) {
    //     if (n == 0) return 0;

    //     int half = 1 << (n - 1); // 2^(n-1)
    //     if (r < half && c < half) return findZ(n - 1, r, c); // 1사분면
    //     if (r < half && c >= half) return half * half + findZ(n - 1, r, c - half); // 2사분면
    //     if (r >= half && c < half) return 2 * half * half + findZ(n - 1, r - half, c); // 3사분면
    //     return 3 * half * half + findZ(n - 1, r - half, c - half); // 4사분면
    // }

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int r = sc.nextInt();
    //     int c = sc.nextInt();
    //     sc.close();

    //     System.out.println(findZ(n, r, c));
    // }
}
