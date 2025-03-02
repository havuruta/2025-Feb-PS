package chomingi;

import java.io.*;
import java.util.*;

public class B12100 {
    static int N, max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        max = Integer.MIN_VALUE;

        dfs(0, arr);
        System.out.println(max);
    }

    static void dfs(int depth, int[][] arr){
        if (depth == 5){
            max = Math.max(max, Arrays.stream(arr).mapToInt(row -> Arrays.stream(row).max().getAsInt()).max().getAsInt());
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] newArr = swipeTo(i, copyBoard(arr));
            dfs(depth+1, newArr);
        }
    }

    static int[][] copyBoard(int[][] board) {
        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++){
            newBoard[i] = Arrays.copyOf(board[i], N);
        }
        return newBoard;
    }

    static int[][] swipeTo(int direction, int[][] arr){
        switch (direction){
            case 0:
                return swipeLeft(arr);
            case 1:
                return swipeRight(arr);
            case 2:
                return swipeUp(arr);
            case 3:
                return swipeDown(arr);
        }
        return arr;
    }

    static int[][] swipeLeft(int[][] arr){
        int temp = 0;
        for(int r = 0; r < N; r++){
            int c = 0;
            int p = 0;
            temp = 0;

            while (c<N){
                if (arr[r][c]==0){
                    c++;
                    continue;
                }
                if (temp == 0){
                    temp = arr[r][c];
                    c++;
                    continue;
                }

                if (temp == arr[r][c]){
                    arr[r][p] = temp*2;
                    p++;
                    temp = 0;
                } else {
                    arr[r][p] = temp;
                    p++;
                    temp = arr[r][c];
                }
                c++;
            }
            for (int i = p; i < N; i++) arr[r][i] = 0;
            if (temp != 0) arr[r][p] = temp;
        }
        return arr;
    }
    
    static int[][] swipeRight(int[][] arr){
        int temp = 0;
        for(int r = 0; r < N; r++){
            int c = N-1;
            int p = N-1;
            temp = 0;
            while(c>=0){
                if (arr[r][c]==0){
                    c--;
                    continue;
                }
                if (temp == 0){
                    temp = arr[r][c];
                    c--;
                    continue;
                }
                if (temp == arr[r][c]){
                    arr[r][p] = temp*2;
                    p--;
                    temp = 0;
                } else {
                    arr[r][p] = temp;
                    p--;
                    temp = arr[r][c];
                }
                c--;
            }
            for (int i = p; i >= 0; i--) arr[r][i] = 0;
            if (temp != 0) arr[r][p] = temp;
        }
        return arr;
    }
    
    static int[][] swipeUp(int[][] arr){
        for(int c = 0; c < N; c++){
            int r = 0;
            int p = 0;
            int temp = 0;
            while(r<N){
                if (arr[r][c]==0){
                    r++;
                    continue; 
                }
                if (temp == 0){
                    temp = arr[r][c];
                    r++;
                    continue;
                }
                if (temp == arr[r][c]){
                    arr[p][c] = temp*2;
                    p++;
                    temp = 0;
                } else {
                    arr[p][c] = temp;
                    p++;
                    temp = arr[r][c];
                }
                r++;
            }
            for (int i = p; i < N; i++) arr[i][c] = 0;
            if (temp != 0) arr[p][c] = temp;
        }
        return arr;
    }
    
    static int[][] swipeDown(int[][] arr){
        int temp = 0;
        for(int c = 0; c < N; c++){
            int r = N-1;
            int p = N-1;
            temp = 0;
            while(r>=0){
                if (arr[r][c]==0){
                    r--;
                    continue;
                }
                if (temp == 0){
                    temp = arr[r][c];
                    r--;
                    continue;
                }
                if (temp == arr[r][c]){
                    arr[p][c] = temp*2;
                    p--;
                    temp = 0;
                } else {
                    arr[p][c] = temp;
                    p--;
                    temp = arr[r][c];
                }
                r--;
            }
            for (int i = p; i >= 0; i--) arr[i][c] = 0;
            if (temp != 0) arr[p][c] = temp;
        }
        return arr;
    }

}
