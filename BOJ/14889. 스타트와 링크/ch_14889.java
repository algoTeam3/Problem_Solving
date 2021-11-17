import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_14889{
    static int N, min = Integer.MAX_VALUE;  // N은 무조건 짝수
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0, 0);

        System.out.println(min);
    }

    private static void solve(int cnt, int start) {
        if (cnt == N / 2){
            cal();
            return;
        }

        for (int i = start; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            solve(cnt + 1, i + 1);
            visited[i] = false;
        }

    }

    private static void cal() {
        int start = 0, link = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]){
                    start += map[i][j];
                    start += map[j][i];
                }else if (!visited[i] && !visited[j]){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }
        int result = Math.abs(start - link);

        if (min > result) min = result;
    }
}
