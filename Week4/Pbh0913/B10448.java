package Week4.Pbh0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();
        int n = 1;
        while (true) {
            int N = n * (n + 1) / 2;
            numList.add(N);
            if (N > 1000) { //최대 입력 값이 1000이라 그이상의 삼각수를 구할 필요가 없어서 반복문으로 구함
                break;
            }
            n++;
        }
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean a = false;
            for (int j = 0; j < numList.size(); j++) {
                for (int k = 0; k < numList.size(); k++) {
                    for (int l = 0; l < numList.size(); l++) { //정확히 3개의 삼각수의 합으로 입력값이 나와야 해서 삼중포문
                        if (numList.get(j) + numList.get(k) + numList.get(l) == num) {
                            sb.append(1 + "\n");   //두 값은 고정인 상태에서 ㅣ값만 바꾼 합을 구해 맞으면 입력후 탈출
                            a = true;
                            break;
                        }
                    }
                    if (a) {
                        break;
                    }
                }
                if (a) {
                    break;
                }
            }
            if (!a) {  //값이 없으면 0출력
                sb.append(0 + "\n");
            }
        }
        System.out.println(sb);
    }
}
