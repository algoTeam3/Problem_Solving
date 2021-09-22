import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int r, c, count;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        count = 0;
        map = new int[r][c];
        visit = new boolean[r][c];
        //배열 담기
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        BFS();
        System.out.println(map[r-1][c-1]);

    }

    static void BFS() {
        Queue q = new LinkedList<Integer[]>();

        visit[0][0] = true;
        int[] ints = new int[2];
        ints[0] = 0;
        ints[1] = 0;
        q.offer(ints);

        out:
        while (!q.isEmpty()) {

            int[] s = (int[]) q.poll();


            for (int k = 0; k < 4; k++) {
                int nx = s[0] + dir[k][0];
                int ny = s[1] + dir[k][1];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    int[] ints1 = new int[2];
                    ints1[0] = nx;
                    ints1[1] = ny;
                    map[nx][ny]=map[s[0]][s[1]]+1;

                    q.offer(ints1);


                }

            }

        }
    }
}
