import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 5 6      정점개수, 간선개수
 * 1         시작점
 * 5 1 1
 * 1 2 2
 * 1 3 3
 * 2 3 4
 * 2 4 5
 * 3 4 6
 */
public class ch_1753 {
    static class Node implements Comparable<Node> {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    static int V, E, K, u, v, w;
    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    static final int INFINITY = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        distance = new int[V + 1];
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INFINITY);

        distance[K] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));
        }

        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INFINITY) {
                System.out.println("INF");
            }else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(K, 0));
        while (!pq.isEmpty()) {
            Node a = pq.poll();
            if (visited[a.v]) continue;
            visited[a.v] = true;

            for (Node o : list[a.v]) {
                if (distance[o.v] > distance[a.v] + o.w) {
                    distance[o.v] = distance[a.v] + o.w;
                    pq.add(new Node(o.v, distance[o.v]));
                }
            }
        }
    }
}
