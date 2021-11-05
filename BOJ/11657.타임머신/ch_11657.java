import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_11657 {
    static class Node implements Comparable<Node> {
        int start, end, weight;

        public Node(int start, int dest, int weight) {
            this.start = start;
            this.end = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int N, M;
    static final long INF = Long.MAX_VALUE;
    static Long[] dist;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new Long[N + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new Node(a, b, c));
        }

        if (!bellmanFord()){
            System.out.println(-1);
        }else{
            for (int i = 2; i <= N; i++) {
                System.out.println(dist[i].equals(INF) ? -1 : dist[i]);
            }
        }
    }

    private static boolean bellmanFord() {
        dist[1] = 0L;

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M; j++) {
                Node node = list.get(j);

                if (dist[node.start] == INF) continue;

                if (dist[node.end] > dist[node.start] + node.weight) {
                    dist[node.end] = dist[node.start] + node.weight;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            Node node = list.get(i);

            if (dist[node.start] != INF && dist[node.end] > dist[node.start] + node.weight) {
                return false;
            }
        }
        return true;
    }
}
