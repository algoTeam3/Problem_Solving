
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class oh_16683 {

    private static int answer;
    private static ArrayList<cctv> cctvs;
    private static int n;
    private static int m;
    private static int[] pick;
    private static int[][] del = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; //상 우 하 좌
    private static int[][] map;
    private static int wall;


    private static class cctv {
        int x;
        int y;
        int unit;
        int dir;
        boolean go[];

        private cctv(int x, int y, int unit) {
            this.x = x;
            this.y = y;
            this.unit = unit;
            this.go = new boolean[4];
        }

        private void area() {
            if (unit == 2) {// 방향 2
                if (dir + 2 > 3) {
                    go[dir - 2] = true;
                } else {
                    go[dir + 2] = true;
                }
                go[dir] = true;
            } else if (unit == 3) {// 방향 2개
                if (dir + 1 > 3) {
                    go[0] = true;
                } else{
                    go[dir+1]=true;
                }
            } else if (unit == 4) {// 방향 3개
                if(dir-1<0){ //방향이 0
                    go[3]=true;
                    go[dir+1]=true;
                }else if(dir+1>3){//방향 3개
                    go[0]=true;
                    go[dir-1]=true;
                }else{
                    go[dir-1]=true;
                    go[dir+1]=true;
                }
            }else if(unit==5){
                for (int i = 0; i < go.length; i++) {
                    go[i]=true;
                }
            }
            go[dir] = true;
        }
        private void init(){
            this.go = new boolean[4];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        wall = 0;
        answer = Integer.MAX_VALUE;

        map = new int[n][m];
        cctvs = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new cctv(i, j, map[i][j]));
                }
                if(map[i][j]==6){
                    wall++;
                }
            }
        }
        //조합
        pick = new int[cctvs.size()];
        comb(0);
        System.out.println(answer);
    }

    private static void comb(int cnt) {
        if (cnt == cctvs.size()) {
            answer = Math.min(check(), answer);
            return;
        }
        for (int i = 0; i < 4; i++) {
            pick[cnt] = i;
            comb(cnt + 1);
        }
    }

    private static int check() {
        int[][] temp= new int[n][m];
        //방향넣기
        for (int i = 0; i < cctvs.size(); i++) {
            cctv pos = cctvs.get(i);
            temp[pos.x][pos.y]=pos.unit;
            pos.dir = pick[i];
        }
        //cctv 범위
        for (int k = 0; k < cctvs.size(); k++) {
            cctvs.get(k).area();

            for (int j = 0; j < del.length; j++) {
                if(cctvs.get(k).go[j]){
                    int nx= cctvs.get(k).x;
                    int ny= cctvs.get(k).y;
                    while(true){
                        nx+=del[j][0];
                        ny+=del[j][1];

                        if(nx<0||ny<0||nx>=n||ny>=m)break;
                        if(map[nx][ny]==6)break;
                        if(map[nx][ny]==0){
                            temp[nx][ny]=1;
                        }
                    }
                }
            }
            cctvs.get(k).init();
        }
        //사각지대 체크
        int count = 0;
        for (int[] i : temp) {
            for (int s : i) {
                if (s == 0) count++;
            }
        }
        return count-wall;
    }
}
