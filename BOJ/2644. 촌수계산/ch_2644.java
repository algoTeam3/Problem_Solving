import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ch_2644 {
    static int n, p1, p2, m, x, y;
    static int[][] map;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        st = new StringTokenizer(br.readLine());
        p1 = Integer.parseInt(st.nextToken());
        p2 = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        d = new int[n + 1];
        bfs(p1, p2);
        if(d[p2] == 0) System.out.println(-1);
        else System.out.println(d[p2]);
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()){
            int cur = queue.poll();

            if (cur == end) break;

            for (int i = 1; i <= n; i++) {
                if (map[cur][i] == 1 && d[i] == 0) {
                    d[i] = d[cur] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
