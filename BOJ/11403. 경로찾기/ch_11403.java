import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_11403 {
    static int N;
    static int[][] distance;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        // 초기화
        distance = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(st.nextToken());
                if (distance[i][j] == 0) distance[i][j] = INF;
            }
        }

        // 플로이드 와샬
        for (int k = 0; k < N; k++) {   // 경유지
            for (int i = 0; i < N; i++) {   // 출발지
                for (int j = 0; j < N; j++) {   // 도착지
                    if (distance[i][k] == 1 && distance[k][j] == 1) {
                        distance[i][j] = 1;
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (distance[i][j] == INF) distance[i][j] = 0;  // 무한대인 값은 0으로 변경
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

    }
}
