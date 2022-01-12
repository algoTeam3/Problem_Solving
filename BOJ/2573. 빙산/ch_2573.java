import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 빙산이 두덩어리로 나누어지는 최소 시간(년) 구하기
 * 상하좌우 0의 개수에 따라 빙하가 녹는 높이가 정해진다
 *
 */
public class ch_2573 {
    static int N, M;
    static int[][] map, melt;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        melt = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;

        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j] == 0 && map[i][j] != 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                System.out.println(0);
                break;
            } else if (cnt >= 2) {
                System.out.println(year);
                break;
            }

            melting();
            year++;
        }

    }

    private static void melting() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빙산 녹이기
                map[i][j] -= melt[i][j];

                //높이가 음수면 0으로
                if (map[i][j] < 0) map[i][j] = 0;

                // 초기화
                visited[i][j] = 0;
                melt[i][j] = 0;
            }
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (map[nx][ny] == 0) {
                    melt[x][y]++;
                }

                // 재귀
                if (visited[nx][ny] == 0 && map[nx][ny] != 0){
                    dfs(nx, ny);
                }
            }
        }
    }


}
