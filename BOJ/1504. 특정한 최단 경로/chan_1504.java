import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chan_1504 {
    static ArrayList<Node>[] graph;
    static int N, E;
    static int INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        INF = 10000 * (N - 1) + 1;
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int v1Sum = 0;
        v1Sum += dijkstra(1, v1);
        v1Sum += dijkstra(v1, v2);
        v1Sum += dijkstra(v2, N);

        int v2Sum = 0;
        v2Sum += dijkstra(1, v2);
        v2Sum += dijkstra(v2, v1);
        v2Sum += dijkstra(v1, N);

        int ans = Math.min(v1Sum, v2Sum);
        if (ans >= INF)
            ans = -1;

        System.out.println(ans);
    }

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int curB = pq.poll().b;
            if (visited[curB])
                continue;
            visited[curB] = true;

            for (Node node : graph[curB]) {
                if (dist[node.b] > dist[curB] + node.c) {
                    dist[node.b] = dist[curB] + node.c;
                    pq.offer(new Node(node.b, dist[node.b]));
                }
            }
        }
        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int b;
        int c;

        public Node(int b, int c) {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }

    }
}
