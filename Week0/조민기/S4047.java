package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4047 {
    static Map<Character, Set<Integer>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i<=T; i++){

            map = new HashMap<>();

            map.put('S', new HashSet<>());
            map.put('D', new HashSet<>());
            map.put('H', new HashSet<>());
            map.put('C', new HashSet<>());

            String cards = br.readLine();            
            System.out.println("#"+i+" "+checkCards(cards));
        }
    }

    static String checkCards(String cards){
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j<cards.length()/3;j++) {
            int nums = cards.charAt(3*j+1)*10+cards.charAt(3*j+2);
            if (!map.get(cards.charAt(3*j)).add(nums)){
                return "ERROR";    
            }
        }

        for (char P : new Character[]{'S','D','H','C'}) {
            int temp = 13-map.get(P).size();
            sb.append(temp).append(" ");
        }
        System.out.println();
        
        return sb.toString();
    }
}
