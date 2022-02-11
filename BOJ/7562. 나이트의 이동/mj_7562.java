import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l, ans;
    static int[] dr = {-1,-2,-2,-1,1,2,2,1};
    static int[] dc = {-2,-1,1,2,2,1,-1,-2};
    static boolean[][] v;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            l = Integer.parseInt(br.readLine());
            v = new boolean[l][l];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int dR = Integer.parseInt(st.nextToken());
            int dC = Integer.parseInt(st.nextToken());
            bfs(sR, sC, dR, dC);

            System.out.println(ans);
        }

    }

    private static void bfs(int sR, int sC, int dR, int dC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sR, sC, 0});
        v[sR][sC] = true;

        while(!q.isEmpty()) {
            int[] a = q.poll();
            if (a[0] == dR && a[1] == dC) {
                ans = a[2];
                break;
            }
            // 상/하
            int r = a[0], c = a[1], cnt = a[2];
            for (int d = 0; d < dr.length; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= l || nc < 0 || nc >= l || v[nr][nc]) continue;

                q.offer(new int[]{nr, nc, cnt + 1});
                v[nr][nc] = true;
            }
        }
    }
}
