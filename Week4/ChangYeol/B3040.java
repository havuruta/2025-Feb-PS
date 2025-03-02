package Week4.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B3040 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dwarfsNum = new int[9];
		
		int sum = 0;

		for(int i = 0; i < 9; i++) {
			dwarfsNum[i] = Integer.parseInt(br.readLine());
			sum += dwarfsNum[i];
		}
		
		int target = sum - 100;
		
		int fake1 = 0;
		int fake2 = 0;
		
		for(int i = 0; i < 9; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(dwarfsNum[i] + dwarfsNum[j] == target) {
					fake1 = i;
					fake2 = j;
					break;
				}
			}
		}
		
		ArrayList<Integer> realDwarfs = new ArrayList<>();
		
		for(int i = 0; i < 9; i++) {
			if(i == fake1 || i == fake2) {
				continue;
			}
			else {
				realDwarfs.add(dwarfsNum[i]);
			}
		}
		
		Collections.sort(realDwarfs);
		
		StringBuilder sb = new StringBuilder();
		for(int dwarf : realDwarfs) {
			sb.append(dwarf).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
}
