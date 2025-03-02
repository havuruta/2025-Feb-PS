package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class B1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<Integer> nums = new HashSet<>();
        
        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = 0;
        
        // 쉡게 생각하면 그냥
        // 나눈 나머지가 0일 때만 넣고
        // HashSet.size() 가 3 이상일 때 나오면 됨
        int temp = 1;
        while(res == 0) {
        	nums.clear();
        	for(int i = 0; i < arr.length; i++) {
        		if(temp % arr[i] == 0) {
        			nums.add(arr[i]);
        		}
            }
        	
        	if(nums.size() >= 3) {
        		res = temp;
        	}
        	temp++;
        }
        
        
        bw.write(res+"");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
