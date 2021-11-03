import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_16064_floyd {
    static final int INF = -1000000000;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == j) map[i][j] = 0;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            map[S][T] = Math.max(map[S][T], C);
        }

        // 플로이드 와샬
        for (int K = 1; K <= N; K++){
            for (int i = 1; i <= N; i++){
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Math.max(map[i][j], map[i][K] + map[K][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (ans < map[i][j]) {
                    ans = map[i][j];
                }
            }
        }

        System.out.println(ans);
    }
}
