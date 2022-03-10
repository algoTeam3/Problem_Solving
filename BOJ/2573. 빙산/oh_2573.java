


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class oh_2573 {

    private static int r;
    private static int c;

    private static class xy{
        int x;
        int y;

        public xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] map;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
       int turn =0;

        while (true){
            visited = new boolean[r][c];
            int count =0;
            boolean flag = false;
            int zero =0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(map[i][j]==0){
                        visited[i][j]=true;
                    }else{
                        zero++;
                    }
                }
            }
            if(zero==0){
                turn =0;
                break;}
            turn++;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(visited[i][j])melt(i,j);
                }
            }
            visited = new boolean[r][c];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if(map[i][j]>=1&&!visited[i][j]){
                        flag = true;
                        count++;
                        check(i,j);
                    }
                }
            }
            if(count>1)break ;
            if(!flag){
                turn =0;
                break ;
            }
        }
        System.out.println(turn);
    }

    private static void check(int x,int y) {
        Queue<xy> que = new LinkedList<>();
        xy z = new xy(x,y);
        visited[x][y]=true;
        que.add(z);
        while (!que.isEmpty()){
            xy temp = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dir[i][0];
                int ny = temp.y + dir[i][1];

                if(nx<0||ny<0||nx>=r||ny>=c||map[nx][ny]==0)continue;
                if(!visited[nx][ny]){
                    visited[nx][ny]=true;
                    que.add(new xy(nx,ny));

                }
            }
        }

    }

    private static void melt(int x,int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x+dir[i][0];
            int ny = y+dir[i][1];
            
            if(nx<0||ny<0||nx>=r||ny>=c||map[nx][ny]==0)continue;
            map[nx][ny]-=1;
        }
    }
}
