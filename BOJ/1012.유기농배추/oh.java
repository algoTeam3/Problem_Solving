import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int r, c, count;
    static int[][] map;
    static boolean[][] visit;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            count=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());
            map = new int[r][c];
            visit = new boolean[r][c];
            //배열담기
            for (int z = 0; z < unit; z++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        int[] ints = new int[2];
                        ints[0] = i;
                        ints[1] = j;
                        BFS(ints);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void BFS(int[] x) {
        Queue q = new LinkedList<Integer[]>();
        q.offer(x);
        visit[x[0]][x[1]] = true;
        while (!q.isEmpty()) {
            int[] s = (int[]) q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = s[0] + dir[i][0];
                int ny = s[1] + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (map[nx][ny] == 1&&!visit[nx][ny]) {
                    visit[nx][ny] = true;
                    int[] ints = new int[2];
                    ints[0] = nx;
                    ints[1] = ny;
                    q.offer(ints);
                }

            }
        }
        count++;

    }
}
