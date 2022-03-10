package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ1245
 * @date : 2022-03-03
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_1245 {

    private static int n;
    private static int m;
    private static int count;
    private static boolean[][] mt;

    private static class xy{
        int x;
        int y;

        private xy(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dir ={{-1,0},{1,0},{0,-1},{0,1},{-1,1},{1,-1},{-1,-1},{1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        count = 0;
        map = new int[n][m];
        visited = new boolean[n][m];
        mt = new boolean[n][m];

        //정보입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(!mt[i][j]){
                    bfs(i, j);
                }

            }
        }
        System.out.println(count);
    }

    private static void bfs(int i, int j) {
        visited = new boolean[n][m];
        visited[i][j]=true;
        mt[i][j]=true;
        count++;
        Queue<xy> que = new LinkedList<>();
        que.add(new xy(i,j));

        while (!que.isEmpty()){
            xy z = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = z.x + dir[k][0];
                int ny = z.y + dir[k][1];

                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny])continue;
                if(map[i][j]==map[nx][ny]){
                    visited[nx][ny]=true;
                    mt[nx][ny]=true;
                    que.add(new xy(nx,ny));
                }else if(map[z.x][z.y]<map[nx][ny]){
                    count--;
                    return;
                }
            }
        }
    }
}
