package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class B3040 {
	static List<Integer> res;
	
    public static void main(String[] args) throws IOException {
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        	Random r = new Random();
        	StringBuilder sb = new StringBuilder();
        	
            int [] gnomes = new int [9];
            
            for(int i = 0; i < 9; i++) {
            	gnomes[i] = Integer.parseInt(br.readLine());
            }
            
            int sum = 0;
            boolean[] isPicked = new boolean[9];
            
            while(sum != 100) {
            	sum = 0;
            	isPicked = new boolean[9];
            	res = new ArrayList<>();
            	while(res.size() != 7) {
            		int idx = r.nextInt(9);
            		if(!isPicked[idx]) {
            			isPicked[idx] = true;
            			sum += gnomes[idx];
            			res.add(idx);
            		}
            	}
            }
            
            Iterator<Integer> it = res.iterator();
            
            while(it.hasNext()) {
            	sb.append(gnomes[it.next()]).append("\n");
            }
            
            bw.write(sb.toString());
            bw.flush();
            
            br.close();
            bw.close();
    }
}
