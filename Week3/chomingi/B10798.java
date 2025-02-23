package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] board = new char[5][15];

        for (int i = 0; i<5; i++){
            String now = br.readLine();
            for (int c = 0; c<now.length(); c++){
                board[i][c] = now.charAt(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<15; i++){
            for (int j = 0; j<5; j++){
                sb.append(board[j][i]=='\u0000' ? "" : board[j][i]);
            }
        }
        
        System.out.println(sb.toString());
    }
}
