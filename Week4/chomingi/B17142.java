package chomingi;

import java.io.*;
import java.util.*;

public class B17142 {
    static int N, M;
    static int[][] lab;                // 연구소 맵
    static List<Point> virusList;      // 전체 바이러스 위치
    static boolean[] chosen;           // 어떤 바이러스가 활성화되었는지 표시
    static int emptyCount = 0;         // 빈 칸(0)의 총 개수
    static int result = Integer.MAX_VALUE;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];
        virusList = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                // 1은 벽, 0은 빈 칸, 2는 바이러스(비활성 포함)
                if(now == 1) {
                    lab[i][j] = -1;          // 벽을 -1로 표시
                } else if(now == 2) {
                    lab[i][j] = 2;           // 바이러스
                    virusList.add(new Point(i, j));
                } else {
                    // 빈 칸
                    lab[i][j] = 0;
                    emptyCount++;
                }
            }
        }

        // [중요] 빈 칸이 전혀 없으면 시간은 0 (이미 감염 대상이 없음)
        if(emptyCount == 0) {
            System.out.println(0);
            return;
        }

        chosen = new boolean[virusList.size()];
        // 바이러스 중 M개를 고르는 조합
        chooseVirus(0, 0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    // M개의 바이러스를 선택하기 위한 조합 (DFS)
    static void chooseVirus(int start, int depth){
        if(depth == M){
            int time = spreadVirus();  // 선택된 M개 바이러스로 BFS
            if(time != -1) {
                result = Math.min(result, time);
            }
            return;
        }
        for(int i=start; i<virusList.size(); i++){
            chosen[i] = true;
            chooseVirus(i+1, depth+1);
            chosen[i] = false;
        }
    }

    // BFS로 바이러스 퍼뜨리기
    static int spreadVirus(){
        // 방문 여부 + 각 칸까지 걸린 시간을 dist에 기록
        // dist[r][c] = -1 이면 아직 방문하지 않은 칸
        int[][] dist = new int[N][N];
        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], -1);
        }

        Deque<Point> queue = new ArrayDeque<>();
        // 활성 바이러스(M개) 큐에 넣고 dist=0
        for(int i=0; i<virusList.size(); i++){
            if(chosen[i]){
                Point v = virusList.get(i);
                dist[v.r][v.c] = 0; 
                queue.offer(v);
            }
        }

        int infectedCount = 0;   // 얼마나 많은 빈 칸(0)을 감염시켰는지
        int timeMax = 0;        // 모든 빈 칸을 감염시키는 데 걸린 시간

        // BFS
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int cr = now.r;
            int cc = now.c;
            int ctime = dist[cr][cc];

            for(int i=0; i<4; i++){
                int nr = cr + dx[i];
                int nc = cc + dy[i];
                if(isValid(nr, nc) && lab[nr][nc] != -1 && dist[nr][nc] == -1) {
                    // 벽(-1)이 아니고, 방문 안 한 칸이면
                    dist[nr][nc] = ctime + 1;
                    queue.offer(new Point(nr, nc));

                    // 빈 칸(0)이었다면 감염된 것이므로 infectedCount++
                    // (lab[nr][nc] == 2)인 칸은 '비활성 바이러스'이므로 꼭 감염할 필요는 없음
                    if(lab[nr][nc] == 0) {
                        infectedCount++;
                        timeMax = Math.max(timeMax, dist[nr][nc]);
                    }
                    // lab[nr][nc] == 2인 칸도 이동할 수 있으나, 감염 필수 칸 아님
                }
            }
        }

        // 모든 빈 칸이 감염되지 못했다면 -1
        if(infectedCount != emptyCount) {
            return -1;
        }
        // 모든 빈 칸이 감염된 경우 걸린 시간은 timeMax
        return timeMax;
    }

    static boolean isValid(int r, int c){
        return r>=0 && r<N && c>=0 && c<N;
    }
}
