import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ch_1967 {
    static class Node {
        int e, weight;

        Node(int e, int weight){
            this.e = e;
            this.weight = weight;
        }
    }
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int max_idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[end].add(new Node(start, weight));
            list[start].add(new Node(end, weight));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);
        System.out.println(max);
    }

    private static void dfs(int e, int weight) {
        if (max < weight) {
            max = weight;
            max_idx = e;
        }

        for (Node a : list[e]) {
            if (!visited[a.e]) {
                visited[a.e] = true;
                dfs(a.e, weight + a.weight);
            }
        }
    }
}
