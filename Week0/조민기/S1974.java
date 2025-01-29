package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class S1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++){
            int[][] sudoku = new int[9][9];
            for (int i = 0; i < 9; i++){
                int[] temp = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                sudoku[i] = temp;
            }

            boolean isValid = checkSudoku(sudoku);
            System.out.println("#" + t + " " + (isValid ? 1 : 0));
        }
    }

    static boolean checkSudoku(int[][] board) {
        // 행과 열 검증
        for (int i = 0; i < 9; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (!rowSet.add(board[i][j])) return false;

                if (!colSet.add(board[j][i])) return false;
            }
        }

        // 3x3 블록 검증
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkBlock(board, i, j)) return false;
            }
        }

        return true; 
    }

    static boolean checkBlock(int[][] board, int startX, int startY) {
        Set<Integer> blockSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!blockSet.add(board[startX + i][startY + j])) return false;
            }
        }
        return true;
    }
}
