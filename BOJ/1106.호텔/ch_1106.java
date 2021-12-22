import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = 987654321;

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N + 1];
        int[] customer = new int[N + 1];
        int[] DP = new int[C + 101];
        Arrays.fill(DP, INF);
        DP[0] = 0;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = customer[i]; j < C + 101; j++) {
                DP[j] = Math.min(DP[j], cost[i] + DP[j - customer[i]]);
            }
        }

        int min = INF;
        for (int i = C; i < C + 101; i++) {
            min = Math.min(min, DP[i]);
        }

        System.out.println(min);
    }
}