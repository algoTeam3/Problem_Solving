import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 바이러스 활성상태 / 비활성 상태
 * 상하좌우로 인접한 모든 빈칸에 동시 복제
 * 연구소의 크기 N, 놓을수 있는 바이러스의 개수 M
 * 0 = 빈칸, 1 = 벽, 2 = 바이러스
 */
public class ch_17142 {
    static class Pos {
        int x, y, time;
        public Pos(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int N, M, spaceCnt = 0, ans = Integer.MAX_VALUE;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static ArrayList<Pos> virus = new ArrayList<>();
    static boolean[][] visited;
    static Pos[] selectedV;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        selectedV = new Pos[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // virus 위치 저장
                if (map[i][j] == 2) virus.add(new Pos(i, j, 0));
                // 빈칸 개수 저장
                if (map[i][j] == 0) spaceCnt++;

            }
        }

        comp(0, 0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    //  조합
    private static void comp(int cnt, int start) {
        if (cnt == M){
            ans = Math.min(ans, bfs());
            return;
        }
        for (int i = start; i <= virus.size() - 1; i++) {
            selectedV[cnt] = virus.get(i);
            comp(cnt + 1, i + 1);
        }
    }

    // BFS
    private static int bfs() {
        Queue<Pos> q = new LinkedList<>();
        visited = new boolean[N][N];
        int zeroCnt = 0;
        int time = 0;

        for (int i = 0; i < M; i++) {
            q.offer(selectedV[i]);
        }

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            int curT = cur.time;

            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 방문했거나, 벽일 때
                if (visited[nx][ny] || map[nx][ny] == 1) continue;

                if (map[nx][ny] != 1 && !visited[nx][ny]){
                    if (map[nx][ny] == 0){
                        zeroCnt++;
                        time = curT + 1;
                    }
                    visited[nx][ny] = true;
                    q.offer(new Pos(nx, ny, curT + 1));
                }
            }
        }
        // 맵의 빈칸의 개수와 같을 때 모두 확산으로 종료
        if (spaceCnt == zeroCnt) return time;

        // 모두 확산 시키지 못했으므로 갱신 x
        return Integer.MAX_VALUE;
    }
}
