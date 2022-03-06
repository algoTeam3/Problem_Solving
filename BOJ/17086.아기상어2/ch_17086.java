import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17086_아기상어2 {
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int[][] map;
    static int N, M, max;
    static boolean[][] visited;
    // 안전 거리는 그 칸과 가장 거리가 가까운 아기 상어와의 거리
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0){
                    int temp = bfs(i,j);
                    max = temp > max ? temp : max ;
                }
            }
        }
        System.out.println(max);
    }

    private static int bfs(int x, int y) {
        visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;
         while (!q.isEmpty()){
            int[] arr = q.poll();
            // 팔방탐색
            for (int d = 0; d < 8; d++) {
                int nx = arr[0] + dx[d];
                int ny = arr[1] + dy[d];
                int dis = arr[2];
                // 범위 체크, 방문 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

                // 상어에 닿을 시 거리 반환
                if (map[nx][ny] == 1) return dis + 1;

                q.offer(new int[]{nx, ny, arr[2] + 1});
                visited[nx][ny] = true;
            }
        }
        return 0;
    }
}
