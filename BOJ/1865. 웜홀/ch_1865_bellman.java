import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_1865_bellman {
    static class Node {
        int start, end, weight;

        public Node(int start, int dest, int weight) {
            this.start = start;
            this.end = dest;
            this.weight = weight;
        }


    }
    static int N, M, W;
    static final int INF = 1000000000;
    static int[] dist;
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();

            for (int i = 0; i < M ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list.add(new Node(start, end, weight));
                list.add(new Node(end, start, weight));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                list.add(new Node(start, end, -1 * weight));
            }

            if (bellmanFord()){
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);

    }

    private static boolean bellmanFord() {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean flag = false;

        outer : for (int i = 1; i <= N; i++) {
            flag = false;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);

                if (dist[node.end] > dist[node.start] + node.weight) {
                    dist[node.end] = dist[node.start] + node.weight;
                    flag = true;

                    if (i == N){
                        flag = true;
                        break outer;
                    }
                }
            }
            if (!flag) break;
        }
        return flag ? true : false;
    }
}
