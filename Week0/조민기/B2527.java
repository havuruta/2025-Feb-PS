package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2527 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int xl1,yl1,xr1,yr1,xl2,yl2,xr2,yr2;
        for (int i = 0; i<4; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            xl1 = Integer.parseInt(st.nextToken());
            yl1 = Integer.parseInt(st.nextToken());
            xr1 = Integer.parseInt(st.nextToken());
            yr1 = Integer.parseInt(st.nextToken());
            xl2 = Integer.parseInt(st.nextToken());
            yl2 = Integer.parseInt(st.nextToken());
            xr2 = Integer.parseInt(st.nextToken());
            yr2 = Integer.parseInt(st.nextToken());

            // a옵션이 가장 체킹이 어려워서 else 로 처리.
            if (xr2<xl1 || xr1<xl2 || yr2<yl1 || yr1<yl2) System.out.println("d");
            else if ((xr1==xl2 && yr1==yl2) || (xr1==xl2 && yl1==yr2) || (xl1==xr2 && yl1==yr2) || (xl1==xr2 && yr1==yl2)) System.out.println("c");
            else if ((xr1>xl2 && yl1==yr2) || (xr1==xl2 && yl1<yr2) || (xr1>xl2 && yr1==yl2) || (xl1==xr2 && yr1>yl2)) System.out.println("b");
            else System.out.println("a");
        }
    }
}