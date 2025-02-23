package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class B2667 {
    static boolean[][] map;
    static boolean[][] visited;
    static int N;
    static List<Integer> res;
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

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        res = new ArrayList<>();

        findComplexes();

        Collections.sort(res);
        System.out.println(res.size());
        for (int r : res) System.out.println(r);
    }

    static void findComplexes() {
        visited = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[y][x] && map[y][x]) {
                    res.add(bfsOneComponent(y, x));
                }
            }
        }
    }
    
    static int bfsOneComponent(int startY, int startX) {
        Deque<Point> queue = new ArrayDeque<>();
        queue.add(new Point(startY, startX));
        visited[startY][startX] = true;
    
        int count = 0;
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (isValid(ny, nx) && !visited[ny][nx] && map[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.add(new Point(ny, nx));
                }
            }
        }
        return count;
    }
    
}
