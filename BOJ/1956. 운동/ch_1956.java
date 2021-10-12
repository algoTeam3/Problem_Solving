import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_1956 {
    static int V, E;
    static int[][] distance;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        //초기화
        distance = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                distance[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            distance[a][b] =  weight;
        }

        // 플로이드 와샬
        for (int k = 1; k <= V; k++) {   // 경유지
            for (int i = 1; i <= V; i++) {   // 출발지
                for (int j = 1; j <= V; j++) {   // 도착지
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        // 출력
        int ans = INF;
        for (int i = 1; i <= V; i++) ans = Math.min(ans, distance[i][i]);
        ans = (ans == INF) ? -1 : ans;  // 값이 변경되지 않았으면 -1
        System.out.println(ans);
    }
}
