
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class oh_21610 {
    private static int n;
    private static int[][] dir = {{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    private static int[][] map;

    private static class Cloud{
        private ArrayList<int[]> cl;
        private boolean[][] visited;

        private Cloud(){
            this.cl= new ArrayList<>(Arrays.asList(new int[]{n-1,0},new int[]{n-1,1},new int[]{n-2,0},new int[]{n-2,1}));
        }
        private void go(int d,int s){
            for (int i = 0; i < cl.size(); i++) {
                for (int j = 0; j < s; j++) {
                    cl.get(i)[0]+=dir[d][0];
                    cl.get(i)[1]+=dir[d][1];

                    if(cl.get(i)[0]<0){
                        cl.get(i)[0]=n-1;
                    }else if(cl.get(i)[0]>=n){
                        cl.get(i)[0]=0;
                    }

                    if(cl.get(i)[1]<0){
                        cl.get(i)[1]=n-1;
                    }else if(cl.get(i)[1]>=n){
                        cl.get(i)[1]=0;
                    }
                }
            }
            rain();
        }
        private void rain(){
            visited = new boolean[n][n];
            for (int i = 0; i < cl.size(); i++) {
                map[cl.get(i)[0]][cl.get(i)[1]]+=1;
                visited[cl.get(i)[0]][cl.get(i)[1]]=true;
            }
        }
        private void bug(){
            int[][] dir={{-1,1},{-1,-1},{1,-1},{1,1}};
            for (int i = 0; i < cl.size(); i++) {
                for (int j = 0; j < 4; j++) {

                   int nx = cl.get(i)[0]+ dir[j][0];
                   int ny = cl.get(i)[1]+ dir[j][1];

                   if(nx<0||ny<0||nx>=n||ny>=n)continue;
                   if(map[nx][ny]>=1)map[cl.get(i)[0]][cl.get(i)[1]]+=1;
                }
            }
        }
        private void check(){
            cl=new ArrayList<>();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    if(visited[i][j])continue;
                    if(map[i][j]>=2){
                        map[i][j]-=2;
                        cl.add(new int[]{i,j});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        map = new int[n][n];

        //정보 입력
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Cloud cloud = new Cloud();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            //구름체크
            if(i!=0)cloud.check();
            //이동
            cloud.go(d-1,s);
            //물복사버그
            cloud.bug();
        }
        cloud.check();
        int sum =0;
        for (int[] ints : map) {
            for (int i : ints) {
                sum+=i;
            }
        }
        System.out.println(sum);
    }
}
