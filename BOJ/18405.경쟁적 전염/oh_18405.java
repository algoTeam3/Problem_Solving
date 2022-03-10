
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ18405
 * @date : 2022-03-03
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class oh_18405{

    private static Queue<xy> que;
    private static ArrayList<xy> arr;

    private static class xy implements Comparable<xy>{
        int x;
        int y;
        int val;

        private xy(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(xy o) {
            return this.val - o.val;
        }
    }

    private static int[][] map;
    private static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        que = new LinkedList<xy>();
        arr = new ArrayList<>();

        //정보 입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());

                if(map[i][j]!=0){
                    arr.add(new xy(i,j,map[i][j]));
                }
            }
        }
        Collections.sort(arr);
        for (xy xy : arr) {
            que.add(xy);
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        boolean flag = true;
        for (int i = 0; i < S; i++) {
            if(arr.isEmpty()||map[x-1][y-1]!=0){
                System.out.println(map[x-1][y-1]);
                flag = false;
                break;
            }else{
                que = new LinkedList<>(arr);
                bfs();
            }
        }
        if(flag){
            System.out.println(map[x-1][y-1]);
        }
    }

    private static void bfs() {
        while(!que.isEmpty()){

            xy z = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = z.x + dir[i][0];
                int ny = z.y + dir[i][1];

                if(nx<0||ny<0||nx>=map.length||ny>=map.length||map[nx][ny]!=0)continue;

                    map[nx][ny]=z.val;
                    arr.add(new xy(nx,ny,z.val));


            }
        }
    }
}
