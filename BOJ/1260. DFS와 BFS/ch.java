package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_S2_1260_DFSBFS {
    static int N, C; // 정점 개수
    static int start;
    static boolean[][] adjMatrix; // 인접행렬 (가중치 없음)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        adjMatrix = new boolean[N+1][N+1];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[to][from] = adjMatrix[from][to] = true;
        }
            boolean[] visited = new boolean[N + 1];
            dfs(start, visited);
            System.out.println();
            bfs();
    }

    private static void dfs(int current,boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");
        for (int i = 1; i <=N ; i++) {
            if (!visited[i] && adjMatrix[current][i]) {
                dfs(i, visited);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[N + 1];

        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int i = 1; i <= N; i++) {
                if(!visited[i] && adjMatrix[current][i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
