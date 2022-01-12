import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ch_2667 {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int N, cnt;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> al = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    dfs(i, j, visited);
                    al.add(cnt);
                }
            }
        }

        System.out.println(al.size());
        Collections.sort(al);
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny, visited);
                    cnt++;
                }
            }
        }
    }


}
