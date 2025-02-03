package 조민기;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
public class B10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();

        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) arr[i] = -1;

        for (int i = 0; i < A.length(); i++) {
            int index = A.charAt(i) - 'a';
            if (arr[index] == -1) arr[index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : arr) sb.append(a).append(" ");
        System.out.println(sb.toString().trim());
    }
}
