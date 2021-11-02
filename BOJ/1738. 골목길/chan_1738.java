import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 금품의 양이 최대가 되는 최적 경로를 구해라
 * 
 * 입력 - 첫째줄 : 골목길들이 교차하는 지점의 개수 n, 골목길의 개수 m - m개 줄 : 골목길 정보 u, v, w - u번 교차점에서
 * v번 교차점으로 이동할 수 있는 일방통행 골목길, - w는 지날 때 갈취 혹은 획득당하는 양 출력 : 최적경로일 때 교차점들의 번호 출력,
 * 최적 경로가 없으면 -1
 * 
 * @author chaeu
 *
 */
public class chan_1738 {
    public static class Oneway {
        int start;
        int end;
        int weight;

        public Oneway(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static Oneway[] ways;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        final int min = Integer.MIN_VALUE;
        ways = new Oneway[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            ways[i] = new Oneway(u, v, w);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, min);
        dist[n] = 0;
        int[] path = new int[n + 1];
        path[n] = n;

        boolean updated = false;
        for (int i = 0; i < n; i++) {
            updated = false;
            for (int j = 0; j < m; j++) {
                int u = ways[j].start;
                int v = ways[j].end;
                int w = ways[j].weight;
                // 더 유리한 거리가 있다면 갱신
                if (dist[v] != min && dist[u] < dist[v] + w) {
                    dist[u] = dist[v] + w;
                    path[u] = v;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }

        if (updated || dist[1] == min)
            System.out.println(-1);
        else {
            StringBuilder sb = new StringBuilder();
            int idx = 1;
            while (idx != n) {
                sb.append(idx).append(' ');
                idx = path[idx];
            }
            sb.append(n);
            System.out.println(sb);
        }

    }

}
