import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ch_5972 {
    static class Node {
        int node, cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<Node>();
        }
        dist = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        dist[0] = 0;
        visited[0] = true;
        // 다익스트라
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {    // 우선순위큐 정렬
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });
        q.add(new Node(0, 0));
        while (!q.isEmpty()) {
            // 노드 선택
            Node temp = q.poll();
            if (temp.node == N - 1) continue;
            visited[temp.node] = true;
            for (Node n :
                    list[temp.node]) {
                // 노드 값 비교로 최소비용 구하기
                if (!visited[n.node] && dist[temp.node] + n.cost < dist[n.node]) {
                    dist[n.node] = dist[temp.node] + n.cost;
                    q.add(new Node(n.node, dist[n.node]));
                }
            }
        }
        System.out.println(dist[N - 1]);

    }
}
