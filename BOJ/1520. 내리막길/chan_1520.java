package BOJ.1520.내리막길;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 높이가 적힌 지도가 주어졌을 때, 출발지(0,0)에서 도착지(M-1, N-1)까지 항상 내리막길로만 이동하는 경로의 개수를
 * 구해라.
 */
public class chan_1520 {

    static int N, M, ans;
    static int[][] map, dp;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int n = 0; n < N; n++) {
                map[m][n] = Integer.parseInt(st.nextToken());
                dp[m][n] = -1;
            }
        }
        dfs(0, 0);

        System.out.println(dp[0][0]);
    }

    private static int dfs(int x, int y) {
        // 도착지에 도달한 경우 1을 리턴해서 메모하기
        if (x == M - 1 && y == N - 1)
            return 1;
        // 한번도 가지 않은 칸일 때 수행
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            // 사방탐색
            for (int d = 0; d < 4; d++) {
                int nx = dx[d] + x;
                int ny = dy[d] + y;
                if (nx < 0 || ny < 0 || nx >= M || ny >= N)
                    continue;
                if (map[nx][ny] >= map[x][y])
                    continue; // 높이가 같거나 큰 경우는 제외

                dp[x][y] += dfs(nx, ny); // 지나온 경로에 1씩 더해서 도착지까지 갈 수 있는 경로일 때, 그 칸에 방문한 횟수 저장
            }
        }
        return dp[x][y];
    }

}
