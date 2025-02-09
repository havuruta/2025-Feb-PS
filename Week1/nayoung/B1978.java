package nayoung;
// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
import java.util.Scanner;

public class B1978 {
    public static void main(String[] args) {
        // 문제 1978 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 0; //소수 개수

        for(int i=0;i<n;i++){
            int a = sc.nextInt();

            //소수 여부 파악을 위한 코드
            int m=2;    // 나누는 값을 2부터 시작
            while(m!=0){
                if(a!=1){   // 1이 아닐 때만 고려
                    if(a%m==0){  // 나머지가 0이고
                        if(a/m==1){ // 몫이 1이라면 더이상 나누어질 수 없는 수이므로 소수이다.
                            cnt++;
                            m=0;
                        }else{  // 몫이 1이 아니라면 더 나누어질 수 있는 수이므로 소수가 아니다.
                            m=0;
                        }
                    }else{
                        m++;
                    }
                }else{  //주어진 수가 1이면 m=0을 할당해 반복문을 멈춘다.
                    m=0;
                }
            }
        }
        System.out.println(cnt);
    }
}
