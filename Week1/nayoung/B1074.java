package nayoung;
// B1074.java - 미해결.
// 문제 1074: Z - Z 모양으로 배열을 탐색하여 특정 위치 계산.
import java.util.Scanner;

public class B1074 {
    public static void main(String[] args) {
        // 문제 1074 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
        int n = 3;

        // 2^n 값 구하기
        int val = square(2,n); // val = 8
        System.out.println(val); // 확인용 출력 - 이후 주석 처리

        //
        int r = 5;  // r행
        int c = 8;  // c열
        int idx = 0;
        if(r%2==1){
            if(c%2==1){
                idx = (r-1)*val + 2*(c-1);
            }else{
                idx = (r-1)*val + 2*(c-2);
            }
        }else{
            if(c%2==1){
                idx = (r-2)*val + 2*(c-1);
            }else{
                idx = (r-2)*val + 2*(c-2);
            }
        }
        System.out.println(idx);  // 확인용 출력 - 이후 주석 처리

        for(int i=0;i<val;i+=2){

        }
    }

    // k^n 메서드 생성
    public static int square(int k, int n){
        int val = 1;
        for(int i=0;i<n;i++){
            val*=k;
        }
        return val;
    }
}
