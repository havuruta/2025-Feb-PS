package chomingi;

import java.io.*;
import java.util.Arrays;

public class B3273 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .toArray();
        
        int x = Integer.parseInt(br.readLine());
        
        int start = 0;
        int end = a.length-1;
        
        int res = 0;

        while (start<end) {
            int now = a[end]+a[start];
            if (x == now){
                res++;
            }

            if (now>x) end--;
            else start++;
        }

        System.out.println(res);
    }
}
