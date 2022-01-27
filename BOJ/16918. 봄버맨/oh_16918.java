

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ16918
 * @date : 2022-01-20
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_16918 {
    static int R,C,N;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        //맵 구성
        for (int i = 0; i < map.length; i++) {
            String str = br.readLine();
            for (int j = 0; j < map[0].length; j++) {
                char ch  = str.charAt(j);
                if(ch=='.')continue;
                else if(ch=='O')map[i][j]=2;
            }
        }
        while (N!=1){
            N-=1;

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    map[i][j]+=1;
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if(map[i][j]==4){
                        Bomb(i,j);
                    }

                }
            }

        }
        for (int[] i : map) {
            for (int answer : i) {
                if(answer==0){
                    System.out.print(".");
                }else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    private static void Bomb(int r,int c) {
        int[][] dir =  {{-1,0},{1,0},{0,-1},{0,1}};

        for (int i = 0; i < 4; i++) {
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];

            if(nr<0||nr>=R||nc<0||nc>=C)continue;
            if(map[nr][nc]==4)continue;
            map[nr][nc]=0;
        }
            map[r][c]=0;
    }
}
