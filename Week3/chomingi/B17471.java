package chomingi;

import java.io.*;
import java.util.*;

public class B17471 {
    static int N, minDiff, totalPopulation;
    static Set<Integer>[] adjacency;
    static int[] population;
    static boolean[] isDistrictA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        population = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            population[i] = num;
            totalPopulation += num;
        }

        adjacency = new HashSet[N+1];
        for (int i = 1; i <= N; i++) {
            adjacency[i] = new HashSet<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                adjacency[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        isDistrictA = new boolean[N+1];
        minDiff = Integer.MAX_VALUE;

        partition(1, 0);

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 선거구를 나누는 DFS
    static void partition(int start, int count) {
        // A구역에 최소 1개 이상 들어있으면 인구 차이를 계산
        if (count >= 1) {
            minDiff = Math.min(minDiff, getPopulationDiff());
        }
        // A/B 구역을 할당하며 모든 부분집합을 탐색
        for (int i = start; i < N; i++) {
            isDistrictA[i] = true;
            partition(i + 1, count + 1);
            isDistrictA[i] = false;
            partition(i + 1, count + 1);
        }
    }

    // 두 선거구 모두 연결되어 있는지 확인 후 인구 차이 반환
    static int getPopulationDiff() {
        if (!checkConnected(true)) return Integer.MAX_VALUE;
        if (!checkConnected(false)) return Integer.MAX_VALUE;

        int sumA = 0;
        for (int i = 1; i <= N; i++) {
            if (isDistrictA[i]) sumA += population[i];
        }
        return Math.abs(totalPopulation - 2 * sumA);
    }

    // isA == true면 A구역, false면 B구역의 연결성 체크
    static boolean checkConnected(boolean isA) {
        boolean[] visited = new boolean[N+1];
        // 구역에 속한 첫 노드를 찾는다
        int start = -1;
        for (int i = 1; i <= N; i++) {
            if (isDistrictA[i] == isA) {
                start = i;
                break;
            }
        }
        // 해당 구역에 노드가 전혀 없으면 연결성 검사가 무의미하므로 true
        if (start == -1) return true;

        // BFS 혹은 DFS로 연결성 검사
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adjacency[current]) {
                if (!visited[next] && isDistrictA[next] == isA) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        // 해당 구역 노드가 모두 방문됐는지 확인
        for (int i = 1; i <= N; i++) {
            if (isDistrictA[i] == isA && !visited[i]) {
                return false;
            }
        }
        return true;
    }
}
