import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1245_농장관리 {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    static int N, M, minH , ans;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        ans = 0;
        minH = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                minH = Math.min(minH, map[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;
                bfs(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(x, y));
        visited[x][y] = true;
        //산봉우리 체크
        boolean flag = true;

        while (!q.isEmpty()) {
            Pos temp = q.poll();
            for (int d = 0; d < 8; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];
                // 범위체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 더 높은 위치가 존재
                if (map[nx][ny] > map[x][y]) {
                    flag = false;
                } else if (!visited[nx][ny] && map[nx][ny] == map[x][y]) {
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny));
                }
            }
        }
        if (flag && map[x][y] > minH) ans++;
    }
}
