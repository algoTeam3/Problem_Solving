import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_7562 {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    // 팔방 탐색
    static int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    static int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    static int[][] map;
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE, l;
    static int[] dest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 테스트케이스
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            // 체스판 한변의 길이
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];
            visited = new boolean[l][l];
            // 현재 위치
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            // 목적지
            dest = new int[2];
            st = new StringTokenizer(br.readLine());
            dest[0] = Integer.parseInt(st.nextToken());
            dest[1] = Integer.parseInt(st.nextToken());

            BFS(curX, curY);
        }
    }

    private static void BFS(int x, int y) {
        Queue<Pos> pq = new LinkedList<>();
        pq.offer(new Pos(x, y));

        visited[x][y] = true;
        while (!pq.isEmpty()) {
            Pos temp = pq.poll();

            // 종료 체크
            if (temp.x == dest[0] && temp.y == dest[1]){
                System.out.println(map[temp.x][temp.y]);
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];

                // 범위체크
                if (nx < 0 || ny < 0 || nx >= l || ny >= l) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                map[nx][ny] = map[temp.x][temp.y] + 1;
                pq.offer(new Pos(nx, ny));
            }
        }
    }
}
