package chomingi;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;

        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int num = Integer.parseInt(line[j]);
                if (num > max) {
                    max = num;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((row + 1) + " " + (col + 1));
    }
}
