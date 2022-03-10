


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ20165
 * @date : 2022-01-27
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_20165 {
    static int N,M,R,count;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());       // 행
        M = Integer.parseInt(st.nextToken());       // 열
        R = Integer.parseInt(st.nextToken());       // 라운드
        count = 0;
        map = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int offenceX = Integer.parseInt(st.nextToken())-1;
            int offenceY = Integer.parseInt(st.nextToken())-1;
            String temp = st.nextToken();
            int offenceD =0;

            if(temp.equals("E"))offenceD =3;
                else if(temp.equals("W"))offenceD=2;
                else if(temp.equals("S"))offenceD=1;
                else if(temp.equals("N"))offenceD=0;

            st = new StringTokenizer(br.readLine());
            int diffenceX = Integer.parseInt(st.nextToken())-1;
            int diffenceY = Integer.parseInt(st.nextToken())-1;

            //공격
           Offence(offenceX,offenceY,offenceD);
            //수비
            visit[diffenceX][diffenceY]=false;


        }

        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for (boolean[] i : visit) {
            for (boolean s : i) {
                if(s) sb.append("F"+" ");
                else sb.append("S"+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
                
    }

    private static void Offence(int x,int y,int d) {
        count++;
        if(visit[x][y])return;
        visit[x][y]=true;
        int n = map[x][y]-1;
        int nx = x;
        int ny = y;

        while (n!=0){
            nx += dir[d][0];
            ny += dir[d][1];

            if(nx<0||nx>=N||ny<0||ny>=M)break;
            if(!visit[nx][ny]&&map[nx][ny]>n)n=map[nx][ny];
            if(!visit[nx][ny])count++;
            visit[nx][ny]=true;
            n--;
        }
    }
}
