import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chan_11657 {
    public static class Bus {
        int start;
        int end;
        int weight;

        public Bus(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static Bus[] bus;
    static int N, M;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선의 개수
        bus = new Bus[M];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()); // 버스 노선 출발지
            int B = Integer.parseInt(st.nextToken()); // 버스 노선 도착지
            int C = Integer.parseInt(st.nextToken()); // 버스 노선 걸리는 시간

            bus[m] = new Bus(A, B, C);
        }

        if (bellmanFord()) { // 음의 사이클이 있을 때,
            System.out.println("-1");
        } else { // 음의 사이클이 없을 때, 1번도시에서 각 도시로 가는 가장 빠른 시간
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }

    }

    static long[] dist;

    public static boolean bellmanFord() {

        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0; // 1번 도시에서 출발

        // 각 정점에서 모든 버스 노선 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int A = bus[j].start;
                int B = bus[j].end;
                int C = bus[j].weight;
                // 더 짧은 거리가 있다면 갱신
                if (dist[A] != INF && dist[B] > dist[A] + C) {
                    dist[B] = dist[A] + C;
                    if (i == N - 1)
                        return true; // 음의 사이클 존재
                }
            }
        }

        return false;
    }
}
