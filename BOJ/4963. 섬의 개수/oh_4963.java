
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class oh_4963 {
    static int r, c, count;
    static int[][] map;
    static boolean[][] visit;
    static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!(str = br.readLine()).equals("0 0")) {
            count = 0;
            StringTokenizer st = new StringTokenizer(str);
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            map = new int[r][c];
            visit = new boolean[r][c];
            //값입력
            for (int i = 0; i < map.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] == 1 && !visit[i][j])
                        Bfs(i, j);
                }
            }
            System.out.println(count);
        }
    }

    private static void Bfs(int X, int Y) {
        count++;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, Y});
        while (!q.isEmpty()) {
            int[] z = q.poll();

//            visit[z[0]][z[1]] = true; //메모리 초과

            for (int i = 0; i < 8; i++) {
                int nr = z[0] + dir[i][0];
                int nc = z[1] + dir[i][1];

                //범위체크
                if (nr < 0 || nc < 0 || nr >= r || nc >= c) continue;
                if (map[nr][nc] == 1 && !visit[nr][nc]) {
                    q.add(new int[]{nr, nc});
                    visit[z[0]][z[1]] = true;
                    visit[nr][nc]=true;
                }
            }
        }
    }
}
