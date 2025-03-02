package Week4.problem;

import java.util.Scanner;

public class B2231 {
    public static void main(String[] args) {
        
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();


        // 최소값을 저장해야할 칭구라..
        int min = 0;
        for(int i =1; i<=N;i++) {
            

            // N까지 가면서 최소합이 될 애를 찾을껀데, 문자열로 하나씩 잘라서 계산할꺼임.
            String numberStr = String.valueOf(i);
            int sum = i;

            // 그렇게 구현 해줌.
            for(int j = 0 ; j< numberStr.length();j ++) {
                sum += numberStr.charAt(j)-'0';
            }
            
            // 만약 나왔다? 그럼 끝내
            if(sum == N) {
                min = i;
                break;
            }
          
        }
        // 0이면 못찾은거니까 0 출력₩
        if(min == 0) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }


    }
}
