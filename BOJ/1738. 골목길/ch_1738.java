import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_1738 {
    static class Node {
        int start, end, weight;

        public Node(int start, int dest, int weight) {
            this.start = start;
            this.end = dest;
            this.weight = weight;
        }


    }
    static int N, M;
    static final int INF = -987654321;
    static int[] dist, previous;
    static ArrayList<Node> edge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            dist = new int[N + 1];
            previous = new int[N + 1];
            Arrays.fill(dist, INF);
            edge = new ArrayList<>();

            for (int i = 0; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edge.add(new Node(start, end, weight));
            }


        }

    }

    //벨만 포드
    private static void bellmanFord() {
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Node node = edge.get(j);

                if (dist[node.start] == INF) continue;
                if (dist[node.end] < dist[node.start] + node.weight) {
                    dist[node.end] = dist[node.start] + node.weight;
                    previous[node.end] = dist[node.start];
                }
            }
        }

        // 음수 사이클
        ArrayList<Integer> list = new ArrayList<>();

        for(int j=0; j<M; j++) {
            Node node = edge.get(j);
            if(dist[node.start] == INF) continue;

            if (dist[node.end] < dist[node.start] + node.weight) {
                list.add(node.end);
            }
        }

    }
}
