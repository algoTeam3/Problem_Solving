import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_2468 {
    static int N, ans;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        ans = 0;
        visited = new boolean[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
            }
        }

        for (int i = 0; i <= maxH; i++) {
            bfs(i);
        }
        System.out.println(ans);
    }

    private static void bfs(int height) {
        int safeCnt = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 방문했을 때
                if (visited[i][j]) continue;
                // 높이보다 작으면 잠기는 영역
                if (map[i][j] <= height) continue;

                // BFS
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()){
                    int[] current = queue.poll();

                    for (int d = 0; d < 4; d++) {
                        int nx = current[0] + dx[d];
                        int ny = current[1] + dy[d];

                        // 범위 체크
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        // 방문하지 않고 잠기지 않는 높이이면 안전영역
                        if (!visited[nx][ny] && map[nx][ny] > height) {
                            visited[nx][ny] = true;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
                safeCnt++;  // 안전영역 카운트
            }
        }
        if (safeCnt > ans) {
            ans = safeCnt;
        }
    }
}
