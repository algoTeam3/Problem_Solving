import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class chan_10282 {
    static int n, d, c, cnt, ans;
    static ArrayList<Node>[] map;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            d = Integer.parseInt(st.nextToken()); // 의존성 개수
            c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호(시작점)
            map = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                map[i] = new ArrayList<>();
            }
            cnt = 0;
            ans = 0;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                map[b].add(new Node(a, s));
            }

            dijkstra(c);

            System.out.println(cnt + " " + ans);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.offer(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.a])
                continue;
            visited[node.a] = true;

            for (Node next : map[node.a]) {
                if (dist[next.a] > dist[node.a] + next.s) {
                    dist[next.a] = dist[node.a] + next.s;
                    pq.offer(new Node(next.a, dist[next.a]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] != INF) {
                cnt++;
                ans = Math.max(dist[i], ans);
            }
        }
    }

    static class Node implements Comparable<Node> {
        int a;
        int s;

        public Node(int a, int s) {
            this.a = a;
            this.s = s;
        }

        @Override
        public int compareTo(Node o) {
            return this.s - o.s;
        }
    }
}
