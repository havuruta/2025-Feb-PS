package chomingi;

import java.io.*;
import java.util.Arrays;

public class B2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solution = Arrays.stream(br.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .sorted()
                                .toArray();

        int start = 0;
        int end = solution.length-1;
        
        int S = 0;
        int E = 0;
        int minVal = Integer.MAX_VALUE;

        while (start<end) {
            int now = solution[end]+solution[start];
            if (minVal>Math.abs(now)){
                minVal = Math.abs(now);
                S = solution[start];
                E = solution[end];
            }

            if (now>0) end--;
            else start++;
        }

        System.out.println(S+ " "+E);
    }
}
