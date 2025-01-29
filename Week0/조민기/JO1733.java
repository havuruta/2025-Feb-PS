package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO1733 {
    static int[][] pattern = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
    static boolean[][] visited = new boolean[21][21];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] omok = new int[21][21];

        for (int i = 1; i<20; i++){
            int[] temp = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            System.arraycopy(temp, 0, omok[i], 1, 19);
        }

        for (int y = 1; y < 20; y++) {
            for (int x = 1; x < 20; x++) {
                if (omok[y][x] == 0 || visited[y][x]) continue;  // 빈칸이거나 이미 방문한 돌이면 패스

                for (int d = 0; d < 4; d++) {
                    if (checkOmok(omok, y, x, d)) {
                        System.out.println(omok[y][x]);
                        System.out.println(y + " " + x);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean checkOmok(int[][] omok, int y, int x, int dir) {
        int color = omok[y][x];
        int count = 1;

        int prevY = y - pattern[dir][0];
        int prevX = x - pattern[dir][1];
        if (prevY >= 1 && prevX >= 1 && prevY <= 19 && prevX <= 19 && omok[prevY][prevX] == color) {
            return false; // 가장 앞쪽 돌이 아니므로 체크할 필요 없음
        }

        int dy = y, dx = x;
        while (true) {  // 같은 방향으로 탐색
            dy += pattern[dir][0];
            dx += pattern[dir][1];

            if (dy < 1 || dx < 1 || dy > 19 || dx > 19 || omok[dy][dx] != color) break;

            count++;
        }

        if (count != 5) return false;

        dy = y;
        dx = x;
        for (int i = 0; i < count; i++) {
            visited[dy][dx] = true;
            dy += pattern[dir][0];
            dx += pattern[dir][1];
        }

        return true;
    }
}