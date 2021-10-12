import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_10159 {
    static final int INF = 98764321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 초기화
        int[][] distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
        }

        //플로이드 와샬
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            int cnt = 0;
            // 반대의 무게 비교가 있을 수 있으므로
            for (int j = 1; j <= N; j++) if (distance[i][j] == INF && distance[j][i] == INF) cnt++;
            System.out.println(cnt);
        }
    }
}
