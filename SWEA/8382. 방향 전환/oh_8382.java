

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * @packageName : SWEA
 * @fileName : 방향전환
 * @date : 2021. 12. 15.
 * @language : JAVA
 * @classification : dij
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:00
 * @submissions : 1
 * @description
 *
 **/
public class oh_8382 {
    static int x1,x2,y1,y2;
    static int[][] row ={{-1,0},{1,0}};

    static class xy{
        int x;
        int y;
        boolean status;
        int count;

        xy(int x,int y,int count,boolean status){
            this.x=x;
            this.y=y;
            this.status = status;
            this.count = count;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());            //testcase

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            int answer =0;

            int X = Math.abs(x1-x2);
            int Y = Math.abs(y1-y2);
            
            if((X+Y)%2==0){
                answer = Math.max(X,Y)*2;
            }else{
                answer = Math.max(X,Y)*2-1;
            }

            System.out.println("#"+i+" "+answer);
        }

    }
}
