import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ch_10282 {
    static class Com implements Comparable<Com> {
        int dest, time;

        public Com(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }

        @Override
        public int compareTo(Com o) {
            return this.time - o.time;
        }
    }
    static int n, d, c, a, b, s, distance[], time, cnt;
    static boolean[] visited;
    static ArrayList<Com>[] adj;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            int start = c;
            distance = new int[n + 1];
            visited = new boolean[n + 1];
            adj = new ArrayList[n + 1];
            time = 0;
            cnt = 0;

            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            Arrays.fill(distance, INF);

            distance[start] = 0;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());
                adj[b].add(new Com(a, s));
            }

            dijkstra(c);
            for (int i = 1; i <= n; i++) {
                if (distance[i] != INF ) time = Math.max(time, distance[i]);
            }
            System.out.println(cnt + " " + time);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Com> pq = new PriorityQueue<>();
        pq.add(new Com(start,0));
        while (!pq.isEmpty()) {
            Com com = pq.poll();
            int dest = com.dest;
            if (visited[dest]) continue;
            else {
                visited[com.dest] = true;
                cnt++;
            }

            for (Com next : adj[dest]) {
                if (distance[next.dest] >= distance[dest] + next.time) {
                    distance[next.dest] = distance[dest] + next.time;
                    pq.add(new Com(next.dest, distance[next.dest]));
                }
            }
        }
    }
}
