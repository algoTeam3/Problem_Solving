package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D4_1226_미로1 {
                    //좌 우 하 상
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] map;
    static boolean[][] checked;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            ans = 0;

            // 맵 입력
            map = new int[16][16];
            checked = new boolean[16][16];
            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            dfs(1,1);


            System.out.println("#" + t + " " + ans);
        }
    }

    private static void dfs(int curX, int curY) {
        checked[curX][curY] = true;

        for (int d = 0; d < 4; d++) {
            int nx = curX + dx[d];
            int ny = curY + dy[d];

            if (nx < 0 || nx >= 16 || ny < 0 || ny >= 16 || checked[nx][ny] || map[nx][ny] == 1 ) continue;

            if (map[nx][ny] == 3) {
                ans = 1;
                return;
            }

            if (map[nx][ny] == 0) dfs(nx, ny);

        }
    }
}
