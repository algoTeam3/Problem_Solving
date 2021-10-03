import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 2665.미로만들기
 *
 * 끝방까지 가는 동안 만난 검은 방을 기록하면서 가면 되지 않을까?
 *
 * 검은 방이 0
 * 흰방이 1이니까 서로 바꿔주면 됨
 *
 */
public class oh_2665 {
    static int n;
    static int[][] map,visit;
    static int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
         map = new int[n][n];
         visit = new int[n][n];
        //값 입력 받기
        for (int i = 0; i < map.length ; i++) {
            String str = br.readLine();
            for (int j = 0; j < map.length; j++) {
                if(str.charAt(j)-'0'==0){
                    map[i][j]=1;
                }else{
                    map[i][j]=0;
                }
                visit[i][j]=Integer.MAX_VALUE;
            }
        }
        Dij();
        System.out.println(visit[n-1][n-1]);
    }

    private static void Dij() {
        PriorityQueue<xy> pq = new PriorityQueue<>();
        pq.add(new xy(0,0,map[0][0]));
        visit[0][0]=map[0][0];

        while(!pq.isEmpty()){
            xy z = pq.poll();

            if(visit[z.x][z.y]<z.value)continue;

            for (int i = 0; i < 4; i++) {
                int nx = z.x+dir[i][0];
                int ny = z.y+dir[i][1];

                //범위체크
                if(nx<0||ny<0||nx>=n||ny>=n)continue;
                if(visit[nx][ny]>visit[z.x][z.y]+map[nx][ny]){
                    visit[nx][ny]=visit[z.x][z.y]+map[nx][ny];
                    pq.add(new xy(nx,ny,map[nx][ny]));
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
