// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B2609 {
    public static void main(String[] args) {
        // 문제 2609 해결을 위한 코드를 작성하세요.


        Scanner sc = new Scanner(System.in);
        
        // 두 자연수 n1, n2
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // 최대 공약수
        int gcd = 0;
        //최소 공배수
        int lcm = 0;

        //큰수를 n1, 작은수를 n2에 담자. 나중에 최소 공배수 찾을 때 편하게..
        if(n1 < n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        // 약수를 담을 리스트
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        // 약수 구하기
        for(int i =1; i<=n1; i++) {
            if(n1 % i == 0) {
                list1.add(i);
            }
        }


        //얘도 마찬가지로 약수 구하기.
        for(int i =1; i<=n2; i++) {
            if(n2 % i == 0) {
                list2.add(i);
            }
        }

        //최대 공약수 구하자. 큰 수의 약수가 들어간 
        for(int i = list1.size()-1; i>=0; i--) {
            if(list2.contains(list1.get(i))) {
                gcd = list1.get(i);
                break;
            }
        }



        // 최소 공배수 구하기
        int i = 1; //곱셈수...??? x1 부터 올라가겠다.
        
        // 최소 공배수가 구해질 때 까지 반복을 돌겠다.
        loop1:while(lcm==0) {
            // 작은 수를 먼저 곱함.
            int temp1 = n2 * i;
            // 1부터 i까지 반복을 돌꺼임
            for(int j = 1; j<=i; j++) {
                // 이제 큰 수에 j를 곱해주는데,
                int temp2 = n1 * j;
                // 반복을 곱하면서 돌다가 제일 처음 나온 같은 수가 최소 공배수.
                if(temp1 == temp2) {
                    //대입해주고
                    lcm = temp1;
                    
                }
            }
            // i를 키워줌. 그래야 작은 수 x1,  작은 수 x2 이렇게 쭉 쭉 나아갈 수 있음...
            i++;
        }
        
        //마무리로 출력 해주고 끝.
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
