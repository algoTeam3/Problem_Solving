import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_1504_특정한최단경로 {
    static class Node implements Comparable<Node> {
        int dest, weight;

        public Node(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int N, E, v1, v2;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] adj;
    static int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        E = Integer.parseInt(st.nextToken());   // 간선 개수

        // 초기화
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        adj = new ArrayList[N + 1];
        INF = 10000 * (N - 1) + 1;
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Node>();
        }


        for (int i = 0; i < E; i++) {   // 정방향, 역방향으로 방향성이 없는 그래프
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   // start
            int b = Integer.parseInt(st.nextToken());   // end
            int c = Integer.parseInt(st.nextToken());   // weight
            adj[a].add(new Node(b, c)); // a -> b 정방향
            adj[b].add(new Node(a, c)); // b -> a 역방향
        }
        st = new StringTokenizer(br.readLine());
        // 반드시 거쳐야할 두 정점
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // v1정점 먼저 지나갈 때
        int result1 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);
        // v2정점 먼저 지나갈 때
        int result2 = 0;
        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);


        int ans = (result1 == INF && result2 == INF) ? -1 : Math.min(result1, result2);
        System.out.println(ans);
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int dest = current.dest;

            if (visited[dest]) continue;
            else visited[dest] = true;

            for (Node next : adj[dest]) {
                if (distance[next.dest] > distance[dest] + next.weight) {
                    distance[next.dest] = distance[dest] + next.weight;
                    pq.add(new Node(next.dest, distance[next.dest]));
                }
            }
        }
        return distance[end];
    }
}
