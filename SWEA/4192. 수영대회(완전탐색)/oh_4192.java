import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class oh_4192 {
    static int N;
    static int[][] map;
    static int[][] dir  = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T  = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N =Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            
            st = new StringTokenizer(br.readLine());
            int[] start = new int[2];
            start[0]= Integer.parseInt(st.nextToken());
            start[1]= Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] end = new int[2];
            end[0]= Integer.parseInt(st.nextToken());
            end[1]= Integer.parseInt(st.nextToken());
            
            bfs(start);
            int answer=map[end[0]][end[1]];
            //도착못함
            if(answer==0)answer=-1;
            System.out.println("#"+test_case+" "+answer);
            
        }
    }

    private static void bfs(int[] start) {
        LinkedList<int[]> que = new LinkedList<>();
        que.add(start);
        map[start[0]][start[1]]=0;

        while(!que.isEmpty()){
            int[] z=que.poll();

            for (int i = 0; i < 4; i++) {
                int nr = z[0]+dir[i][0];
                int nc = z[1]+dir[i][1];

                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(map[nr][nc]==0){
                    map[nr][nc]=map[z[0]][z[1]]+1;
                    que.add(new int[]{nr,nc});
                }
            }
        }
    }
}
