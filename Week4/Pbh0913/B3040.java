package Week4.Pbh0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] shortPeople = new int[9];
        for (int i = 0; i < 9; i++) {
            shortPeople[i] = Integer.parseInt(br.readLine());
        }
        int killIdx1 = 0;
        int killIDx2 = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                int sum = 0;
                for (int k = 0; k < 9; k++) { //삼중 포문으로 두 난쟁이 제외한 합을 구함
                    if (shortPeople[k] != shortPeople[j] && shortPeople[k] != shortPeople[i]) {
                        sum += shortPeople[k];
                    }
                }
                if (sum == 100) {  //7난쟁이  합이 100이면  인덱스 저장
                    killIdx1 = i;
                    killIDx2 = j; 
                    break;
                }
            }
            if (killIdx1 != 0) { //경우의 수는 하나만 존재하기에 찾으면 반복문 탈출
                break;
            }
        }
        for (int i = 0; i < 9; i++) { //입력
            if (shortPeople[killIdx1] != shortPeople[i] && shortPeople[killIDx2] != shortPeople[i]) {
                sb.append(shortPeople[i] + "\n");
            }
        }
        System.out.println(sb);
    }
}
