import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.StringTokenizer;

public class oh_18428{
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;
    static ArrayList<int[]> X, T;
    static boolean[] visit;
    static boolean flag;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        //입력받기
        for (int i = 0; i < map.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        X = new ArrayList<>();
        T = new ArrayList<>();
        Check();
        visit = new boolean[X.size()];
        answer="NO";
        Dfs(0,0);
        System.out.println(answer);

    }

    private static void Dfs(int cnt,int start) {
            if (cnt == 3) {
            if(cal()){
                answer="YES";
            }
            return;
        }
        for (int i = start; i < X.size(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            Dfs(cnt + 1,i+1);
            visit[i] = false;

        }
    }

    private static boolean cal() {
        //맵 복사
        char[][] temp = new char[map.length][map.length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                temp[i][j] = map[i][j];
            }
        }
        
        //장애물 놓기
        for (int i = 0; i < visit.length; i++) {
            if (visit[i]) {
                temp[X.get(i)[0]][X.get(i)[1]] = 'O';
            }
        }
        
        //확인하기
        for (int i = 0; i < T.size(); i++) {
            for (int j = 0; j < 4; j++) {
                int nr = T.get(i)[0];
                int nc = T.get(i)[1];

                while (true) {
                    nr += dir[j][0];
                    nc += dir[j][1];

                    if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) break;
                    if (temp[nr][nc] == 'O') break;
                    if (temp[nr][nc] == 'S') {
                        return false;
                    }
                }
            }
        }
        return true;

    }


    private static void Check() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                //T면 상하좌우로 살피기
                if (map[i][j] == 'T') {
                    T.add(new int[]{i, j});
                    for (int z = 0; z < 4; z++) {

                        int nr = i;
                        int nc = j;

                        while (true) {

                            nr += dir[z][0];
                            nc += dir[z][1];

                            if (nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) break;
                            if (map[nr][nc] == 'S'||map[nr][nc]=='T') break;
                            X.add(new int[]{nr, nc});
                        }
                    }

                }
            }
        }
    }

}
