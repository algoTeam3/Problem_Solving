import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ch_1238 {
    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
    static final int INF = 987654321;
    static ArrayList<ArrayList<Node>> arrList, r_arrList;
    static int N, X;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arrList = new ArrayList<>();
        r_arrList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arrList.add(new ArrayList<>());
            r_arrList.add(new ArrayList<>());
        }

        // arrList와 reverse_arrList를 각각 단방향 인접리스트로 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arrList.get(start).add(new Node(end, weight));
            r_arrList.get(end).add(new Node(start, weight));
        }

        int[] dist1 = dijkstra(arrList);
        int[] dist2 = dijkstra(r_arrList);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist1[i] + dist2[i]);
        }

        System.out.println(ans);
    }

    // 다익스트라 알고리즘
    public static int[] dijkstra(ArrayList<ArrayList<Node>> a) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            int cur = temp.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node n : a.get(cur)) {
                    if (!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                        dist[n.end] = dist[cur] + n.weight;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist;
    }
}
