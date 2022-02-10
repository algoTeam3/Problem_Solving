import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_2638 {
    static class Pos{
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        boolean flag = true;
        while (flag){
            visited = new int[N][M];
            BFS();

            flag = false;
            outer: for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0){
                        flag = true;
                        break outer;
                    }
                }
            }
            time++;
        }
        System.out.println(time);
    }

    private static void BFS() {
        Queue<Pos> q = new LinkedList<>();

        q.offer(new Pos(0, 0));

        while (!q.isEmpty()) {
            Pos temp = q.poll();
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];
                // 방문 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;


                if (map[nx][ny] == 0 && visited[nx][ny]==0) {
                    visited[nx][ny] = 1;
                    q.offer(new Pos(nx, ny));
                }
                if (map[nx][ny] == 1) {
                    visited[nx][ny]++;
                    // 2변 이상 닿아 있어 녹음
                    if (visited[nx][ny] >= 2) map[nx][ny] = 0;
                }
            }
        }
    }
}
