package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class B2468 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static class Point{
        int y;
        int x;

        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static boolean isValid(int y, int x){ return y>=0 && y<N && x>=0 && x<N;}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i<N ;i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int res = -1;
        for (int h = 1; h<=100; h++){
            res = Math.max(res, bfs(h));
        }
        System.out.println(res);
    }

    static int bfs(int height){
        visited = new boolean[N][N];
        int cnt = 0;
        Deque<Point> queue = new ArrayDeque<>();
        for (int y = 0; y<N; y++){
            for (int x = 0; x<N; x++){
                if (!visited[y][x] && map[y][x]>height){
                    visited[y][x] = true;
                    queue.add(new Point(y, x));
                    while (!queue.isEmpty()) {
                        Point now = queue.poll();
                        for (int i = 0; i<4; i++){
                            int ny = now.y+dy[i];
                            int nx = now.x+dx[i];
                            if (isValid(ny,nx) && !visited[ny][nx] && map[ny][nx]>height){
                                visited[ny][nx] = true;
                                queue.add(new Point(ny, nx));
                            }
                        }
                    }
                    cnt++;
                } else visited[y][x] = true;
            }
        }
        return cnt;
    }
}
