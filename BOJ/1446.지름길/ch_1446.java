import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ch_1446 {
    static class Node implements Comparable<Node> {
        int start, end, weight;

        public Node(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, D;
    static ArrayList<Node> list;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //지름길의 개수 N (N <= 12)
        N = Integer.parseInt(st.nextToken());
        // 고속도로의 길이 D (D <= 10000)
        D = Integer.parseInt(st.nextToken());
        dist = new int[D + 1];
        list = new ArrayList<>();

        for (int i = 0; i < D + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, weight));
        }

        dijkstra(0);

        System.out.println(dist[D]);

    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0, 0));

        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            for (Node n :
                    list) {
                if (n.start >= temp.end) {
                    if (n.end > D) continue;
                    int tmp = n.start - temp.end;
                    if (dist[n.end] > dist[temp.end] + n.weight + tmp){
                        dist[n.end] = dist[temp.end] + n.weight + tmp;
                        pq.offer(new Node(temp.end, n.end,dist[n.end]));
                    }
                }
            }
            dist[D] = Math.min(dist[temp.end] + D - temp.end,dist[D]);
        }
    }
}
