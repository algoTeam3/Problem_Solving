import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chan_4192 {

    static int N, A, B, C, D;
    static int[][] pool;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine()); // 수영장의 크기
            pool = new int[N][N]; // 수영장 생성
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    pool[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 수영장 정보 입력받기

            // 시작위치 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // 도착위치 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            C = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            System.out.println("#" + t + " " + bfs());
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[] { A, B, 0 }); // 처음 시작 위치 좌표이고, 시작시 이동 시간은 0
        visited[A][B] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0]; // 현재 위치의 x좌표
            int y = current[1]; // 현재 위치의 y좌표
            int cnt = current[2]; // 현재 위치까지 걸린 시간

            // 기저조건 : 도착 위치일 때 bfs 종료
            if (x == C && y == D)
                return cnt;

            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;
                // 방문체크
                if (visited[nx][ny])
                    continue;
                // 이동 가능한 곳인지 체크
                if (pool[nx][ny] == 1)
                    continue;
                // 이동 가능한 곳 일 때, 큐에 추가하고, 이동시간 1 추가
                queue.add(new int[] { nx, ny, cnt + 1 });
                visited[nx][ny] = true;
            }
        }

        // 도착할 수 없을 때
        return -1;

    }

}
