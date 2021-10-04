package BOJ.2665.미로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class chan_2665 {

    static int[][] map, dist;
    static boolean[][] visited;
    static int N;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dist = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] data = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = 1 - (data[j] - '0');
                dist[i][j] = N * N;
            }
        }
        dist[0][0] = 0;
        solve();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dist[N - 1][N - 1]);
    }

    private static void solve() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            for (int d = 0; d < 4; d++) {
                int nr = dx[d] + r;
                int nc = dy[d] + c;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N)
                    continue;
                if (dist[nr][nc] > dist[r][c] + map[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + map[nr][nc];
                    q.add(new int[] { nr, nc });
                }
            }
        }

    }

}
