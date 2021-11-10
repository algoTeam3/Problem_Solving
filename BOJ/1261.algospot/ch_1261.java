import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ch_1261 {
    static class Pos implements Comparable<Pos> {
        int x, y, cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pos o) {
            return cnt - o.cnt;
        }
    }
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        int ans = bfs(1, 1);
        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
        PriorityQueue<Pos> queue = new PriorityQueue<>();
        queue.offer(new Pos(x, y, 0));
        boolean[][] visited = new boolean[N + 1][M + 1];
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();
            // 도착점 도달시 종료
            if(cur.x == N && cur.y == M) return cur.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // 범위 체크
                if (nx < 1 || ny < 1 || nx > N || ny > M) continue;
                // 벽이 없으면 이동
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny, cur.cnt));
                }

                // 벽이 있으면 부수고 카운트 증가
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Pos(nx, ny, cur.cnt + 1));
                }
            }
        }
        return 0;
    }

}
