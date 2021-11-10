import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_4192 {
    static int N, A, B, C, D;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int ans = 0;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            ans = bfs();

            System.out.println("#" + t + " " + ans);
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {A, B, 0});
        boolean[][] visited = new boolean[N][N];
        visited[A][B] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            // 도착점에 왔을 때
            if (x == C && y == D) return cnt;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 방문했거나 장애물일 때
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, cnt + 1});
            }
        }
        return -1;
    }
}
