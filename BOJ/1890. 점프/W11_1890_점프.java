package DP1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
    가장 왼쪽 위 칸에서 가장 오른쪽 아래 칸까지
    각 칸에는 현재 칸에서 갈 수 있는 거리를 의미한다. 반드시 오른쪽이나 아래쪽으로만 이동한다.
    0은 더 이상 진행을 막는 종착점. 한번 점프할 때 방향을 바꿀 수는 없다.
    모든 경로의 개수를 구하여라
 */

public class W11_1890_점프 {

    static int N;
    static int[][] map;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(map);

        System.out.println(dp[N-1][N-1]);
    }

    static int[] dr = {0,1};
    static int[] dc = {1,0};
    private static void solution(int[][] map) {
        dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 0일때는 움직임이 없다.
                if (map[i][j] == 0) continue;

                // 오른쪽 이동
                int right = j + map[i][j];
                // 아래쪽 이동
                int down = i + map[i][j];

                // 갈 수 있다면 새로 갈 곳의 개수 = 원래 있던 곳의 개수 + 새로 갈 곳의 개수( 여러 방향에서 한 곳으로 모일 수 있다.)
                if (right < N) dp[i][right] = dp[i][j] + dp[i][right];

                if (down < N) dp[down][j] = dp[i][j] + dp[down][j];
            }
        }
    }
}
