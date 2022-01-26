import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_16234 {
    static class Node {
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static ArrayList<Node> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solve());

    }

    private static int solve() {
        int result = 0;
        while (true) {
            boolean moveCk = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            changePopulation(sum);
                            moveCk = true;
                        }
                    }
                }
            }
            if (!moveCk) return result;
            result++;
        }
    }

    private static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (Node n :
                list) {
            map[n.x][n.y] = avg;
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = map[x][y];
        while (!q.isEmpty()) {
            Node temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];
                // 범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                // 방문 체크
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[temp.x][temp.y] - map[nx][ny]);
                if (L <= diff && diff <= R){
                    q.offer(new Node(nx, ny));
                    list.add(new Node(nx, ny));
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }
        return sum;
    }
}
