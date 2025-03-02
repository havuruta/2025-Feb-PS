package Week4.problem;

import java.io.IOException;
import java.util.Scanner;

public class B3040 {
    public static void main(String[] args) {

        // 난쟁쒜들 키 다 더하면 100이잖아 그럼 남은 두명의 합은? 전체에서 100 뺀 값임
        // 더해서 차이만큼 되는 두마리를 찾자.
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);


        int[] nanjaeng = new int[9];


        for(int i = 0; i<nanjaeng.length; i++) {
            nanjaeng[i] = sc.nextInt();
        }

        int nanjanegsSum = 0;
        
        for(int i = 0; i<nanjaeng.length; i++) {
            nanjanegsSum += nanjaeng[i];
        }

        int diff = nanjanegsSum-100; // 이제 두개 더했을 때 이 합이 되는 애들 빼고 넣어주면 됨 ㅎ

        for(int i = 0; i<nanjaeng.length-1; i++) {
            for(int j = i+1; j<nanjaeng.length; j++) {
                // 찾으면 -1로 바꿈.
                if(nanjaeng[i] + nanjaeng[j] == diff) {
                    nanjaeng[i] = -1;
                    nanjaeng[j] = -1;
                }
            }
        }

        
        // 넣어주고 끝~
        for(int i = 0; i<nanjaeng.length; i++) {
            if(nanjaeng[i] != -1) {
                sb.append(nanjaeng[i]).append("\n");
            }
        }

        System.out.println(sb.toString());

    }
}
