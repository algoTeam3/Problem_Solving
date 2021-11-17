import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_2589 {
    static class Pos{
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static int W, H, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'L'){
                    // 거리가 가장 길때 보물 위치
                    ans = Math.max(ans, bfs(i, j));
                }
            }
        }
        System.out.println(ans);
    }

    private static int bfs(int x, int y) {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];
        int dist = 0;
        queue.offer(new Pos(x, y, dist));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Pos curr = queue.poll();
            int curX = curr.x;
            int curY = curr.y;
            dist = curr.dist;
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                // 방문체크
                if (visited[nx][ny]) continue;
                // 육지가 아니면
                if (map[nx][ny] == 'W') continue;

                queue.offer(new Pos(nx, ny, dist + 1));
                visited[nx][ny] = true;
            }
        }
        return dist;
    }
}