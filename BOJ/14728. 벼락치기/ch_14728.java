import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_14728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] K = new int[N + 1];
        int[] S = new int[N + 1];
        int[][] DP = new int[N+1][T+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            K[i] = Integer.parseInt(st.nextToken());
            S[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= T; j++) {
                if (K[i] <= j){
                    DP[i][j] = Math.max(DP[i - 1][j], S[i] + DP[i - 1][j - K[i]]);
                }else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }

        System.out.println(DP[N][T]);
    }
}
