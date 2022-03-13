import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class W5_18405_경쟁적전염 {

    static int N, K, S, X, Y;
    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader( System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 시험관 크기 NxN
        N = Integer.parseInt(st.nextToken());
        // 1부터 K번의 바이러스
        K = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        boolean[][] visited = new boolean[N+1][N+1];
        LinkedList<int[]> list = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) {
                    list.add(new int[] {i, j, map[i][j], 0});
                    visited[i][j] = true;
                }
            }
        }

        Collections.sort(list, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int[] a : list) {
            q.offer(a);
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int solution = solution(q, visited);
        System.out.println(solution);
    }

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    // bfs
    private static int solution(Queue<int[]> q, boolean[][] visited){
        int ans = 0;
        while(!q.isEmpty()){
            if(map[X][Y] != 0) {
                ans = map[X][Y];
                break;
            }

            int[] cur = q.poll();
            for(int d = 0; d < dr.length; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if(nr < 1 || nc < 1 || nr > N || nc > N || visited[nr][nc]) continue;
                map[nr][nc] = cur[2];
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, cur[2], cur[3]+1});
            }

            if(cur[3] >= S) break;
        }

        return ans;
    }
}
