package BOJ.1753.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chan_1753 {
    static class Node implements Comparable<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int V, E, K, end;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node>[] nodeList;
    static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine()) - 1;
        for (int i = 0; i < V; i++) {
            nodeList[i] = new ArrayList<>();
        }
        distance = new int[V];
        visited = new boolean[V];
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            nodeList[u].add(new Node(v, w));
        }
        Arrays.fill(distance, INFINITY);
        dijkstra();

        for (int i = 0; i < V; i++) {
            if (distance[i] == INFINITY) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(K, 0));
        distance[K] = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (visited[node.v])
                continue;
            visited[node.v] = true;
            for (Node n : nodeList[node.v]) {
                if (distance[n.v] > distance[node.v] + n.weight) {
                    distance[n.v] = distance[node.v] + n.weight;
                    q.offer(new Node(n.v, distance[n.v]));
                }
            }

        }
    }

}
