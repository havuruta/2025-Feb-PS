package 조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// B7576.java
// 문제 7576: 토마토 - BFS를 이용하여 토마토가 모두 익는 최소 일수 계산.
public class B7576 {
    static int[][] tomatoes;
    static int N,M;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    static class Point{
        int y, x;
        Point(int y, int x) { this.y = y; this.x = x;}
    }

    static boolean isValid(int y, int x){
        return (y>=0 && x>=0 && y<M && x<N);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomatoes = new int[M][N];

        Deque<Point> deque = new ArrayDeque<>();
        int unripe = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j]==1) {
                    deque.offer(new Point(i, j));
                } else if (tomatoes[i][j]==0) unripe++;
            }
        }
        
        int days = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for(int l = 0; l<size; l++){
                Point now = deque.pollFirst();
                for (int d = 0; d<4; d++){
                    int ny = now.y+dy[d];
                    int nx = now.x+dx[d];
                    if (isValid(ny, nx) && tomatoes[ny][nx]==0){
                        tomatoes[ny][nx]=1;
                        deque.offer(new Point(ny, nx));
                        unripe--;
                    }
                }
            }
            if (!deque.isEmpty()) days++;
        }
        
        if (unripe==0) System.out.println(days);
        else System.out.println(-1);
    }
}
