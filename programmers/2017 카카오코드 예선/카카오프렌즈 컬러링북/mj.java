import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D3_카카오프렌즈컬러링북 {

    public static void main(String[] args) {
        int m = 6, n = 4;
        int[][] picture = {{1, 1, 1, 0},
                            {1, 2, 2, 0},
                            {1, 0, 0, 1},
                            {0, 0, 0, 1},
                            {0, 0, 0, 3},
                            {0, 0, 0, 3}};
        v = new boolean[m][n];
        int[] solution = solution(6, 4, picture);
        System.out.println(Arrays.toString(solution));
    }

    static boolean[][] v;
    static int N, M;
    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        N = n;
        M = m;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] == 0 || v[i][j]) continue;
                int cnt = painted(i, j, picture[i][j], picture);
                if(maxSizeOfOneArea < cnt) maxSizeOfOneArea = cnt;
                numberOfArea++;
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int[] dr = {0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    private static int painted(int i, int j, int color, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        int cnt = 1;
        q.offer(new int[] {i, j});
        v[i][j] = true;

        while(!q.isEmpty()){
            int[] k = q.poll();
            for(int d = 0; d < dr.length; d++){
                int nr = k[0] + dr[d];
                int nc = k[1] + dc[d];
                if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if(picture[nr][nc] != color || v[nr][nc]) continue;
                q.offer(new int[] {nr, nc});
                cnt++;
                v[nr][nc] = true;
            }
        }
        return cnt;
    }
}
