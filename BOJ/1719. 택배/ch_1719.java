import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ch_1719 {
    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node target) {
            return this.cost - target.cost;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static int N, M, K;
    static List<List<Node>> adList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adList = new ArrayList<>();
        // 1부터 시작용
        adList.add(new <Node>ArrayList());
        for (int i = 1; i <= N; i++) {
            adList.add(new <Node>ArrayList());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt((st.nextToken()));
            int v = Integer.parseInt((st.nextToken()));
            int cost = Integer.parseInt((st.nextToken()));
            adList.get(u).add(new Node(v, cost));
            adList.get(v).add(new Node(u, cost));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        // 정답출력
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int[] trace = new int[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        trace[start] = start;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current =  pq.poll();
            if(visited[current.node]) continue;
            visited[current.node] = true;
            for(Node next : adList.get(current.node)) {
                // 최소비용 비교
                if(dist[next.node] > dist[current.node] + next.cost) {
                    dist[next.node] = dist[current.node] + next.cost;
                    // 해당 정점(next)을 거치기 위해서는 현재 정점(current)을 직전에 거쳐야하는 표시
                    trace[next.node] = current.node;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }

        trace(start, trace);
    }

    private static void trace(int start, int[] trace) {
        for(int v = 1; v <= N; v++) {
            // 자기 자신인 경우
            if(v == start) {
                sb.append("- ");
                continue;
            }
            int answer = 0;
            for(int j = v; j != start; j = trace[j]) {
                answer = j;
            }
            sb.append(answer + " ");
        }
        sb.append("\n");
    }
}



