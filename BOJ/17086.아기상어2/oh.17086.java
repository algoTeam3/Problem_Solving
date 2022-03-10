
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ17086
 * @date : 2022-03-03
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_17086 {

    private static int n;
    private static int m;
    private static int answer;

    private static class xy{
        int x;
        int y;
        int dis;

        xy(int x , int y,int dis ){
            this.x = x;
            this.y = y;
            this.dis  = dis;
        }
    }

    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,1},{-1,-1},{1,1},{1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = 0;
        map = new int[n][m];
        visited = new boolean[n][m];

        //정보입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j]==0){
                    visited = new boolean[n][m];
                    visited[i][j]=true;
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);

    }

    private static void bfs(int i, int j) {
        Queue<xy> que  = new LinkedList<>();
        que.add(new xy(i,j,0));

        while (!que.isEmpty()){
            xy z  = que.poll();

            for (int k = 0; k < 8; k++) {
                int nx = z.x + dir[k][0];
                int ny = z.y + dir[k][1];

                if(nx<0||ny<0||nx>=n||ny>=m||visited[nx][ny])continue;
                if(map[nx][ny]==1){
                    answer = Math.max(answer,z.dis+1);
                    return;
                }else{
                    visited[nx][ny]=true;
                    que.add(new xy(nx,ny,z.dis+1));
                }
            }
        }

    }
}
