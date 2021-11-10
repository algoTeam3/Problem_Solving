import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1261.알고스팟
 */
public class Main {
    static int n,m;
    static int[][] map;
    static int[][] visit;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
    static final int INF=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n =Integer.parseInt(st.nextToken());//열
        m = Integer.parseInt(st.nextToken());//행
        
        //입력받기
        map=new int[m][n];
        visit=new int[m][n];
        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j]=str.charAt(j)-'0';
                visit[i][j]=INF;
            }
        }
        
        dij();
        System.out.println(visit[m-1][n-1]);
    }

    private static void dij() {
        PriorityQueue<xy> que = new PriorityQueue<>();
        visit[0][0]=0;
        que.add(new xy(0,0,0));
        while(!que.isEmpty()){
            xy z=que.poll();

            if(visit[z.x][z.y]<z.value)continue;
            for (int i = 0; i < 4; i++) {
                int nr =  z.x+ dir[i][0];
                int nc =  z.y+ dir[i][1];

                if(nr<0||nc<0||nr>=m||nc>=n)continue;
                if(visit[nr][nc]>visit[z.x][z.y]+map[nr][nc]){
                    visit[nr][nc]=visit[z.x][z.y]+map[nr][nc];
                    que.add(new xy(nr,nc,visit[nr][nc]));
                }
            }
        }
    }
}
class xy implements Comparable<xy> {
    int x;
    int y;
    int value;

    xy(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(xy o) {

        return this.value > o.value ? 1 : -1;
    }
}
