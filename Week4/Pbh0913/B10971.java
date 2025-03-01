package Week4.Pbh0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10971 {
    static List<Integer>[] Money;//도시마다 비용을 일차원 배열에 리스트를 담아 저장
    static boolean[] visit;  //방문체크
    static int start; //시작점
    static int totalCity;       //돌아야 하는 도시수
    static int minMoney = Integer.MAX_VALUE; //최저 비용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        totalCity = Integer.parseInt(br.readLine());
        Money = new List[totalCity + 1];   //사이즈 지정 인덱스 편하게 하고 싶어서 +1
        visit = new boolean[totalCity + 1];
        for (int i = 1; i <= totalCity; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Money[i] = new ArrayList<>();   //i번 도시에서 j로 가는 비용을 담아줌
            Money[i].add(0);
            for (int j = 1; j <= totalCity; j++) {
                Money[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i < totalCity + 1; i++) {  //1번 도시부터 N번 도시 까지 출발점을 지정해두고 반복
            visit[i] = true;
            start = i;
            Airplane(i, 0, 0);
            for (int j = 0; j < totalCity + 1; j++) {
                visit[j] = false;  //반복문을 한번 돌때마다 해당 시작 도시의 방문 체크 해제
            }
        }
        sb.append(minMoney);
        System.out.println(sb);
    }

    public static void Airplane(int City, int depth, int useMoney) {
        if (depth == totalCity - 1) {  //모든 도시를 돌았으면  최솟값 비교해서 저장, -1하는 이유는 위에서 +1해줘서
            if(Money[City].get(start)!=0) { //길 N-1번째 도시에서 출발 도시로 갈 수 없을 때 마지막 비용을 더하지 않도록
                int a = Money[City].get(start);
                useMoney += a;
                minMoney = Math.min(minMoney, useMoney);
            }
        } else {
            if (!(Money[City].isEmpty())) {
                for (int i = 1; i < Money[City].size(); i++) {
                    if (!visit[i] && Money[City].get(i) != 0) { //방문을 하지 않았고 갈 수 있는 도시라면
                        visit[i] = true;
                        int a = Money[City].get(i);
                        Airplane(i, depth + 1, useMoney + a);
                        visit[i] = false;
                    }

                }
            }
        }
    }
}
