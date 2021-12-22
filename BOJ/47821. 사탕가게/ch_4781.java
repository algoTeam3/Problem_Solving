import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);

            if (n == 0 && m == 0) break;

            int[] c = new int[n + 1];
            int[] p = new int[n + 1];
            int[] DP = new int[10001];

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                c[i] = Integer.parseInt(st.nextToken());
                p[i] = (int) Math.round(Double.parseDouble(st.nextToken()) * 100);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = p[i]; j <= m; j++) {
                    DP[j] = Math.max(DP[j], DP[j - p[i]] + c[i]);
                }
            }

            System.out.println(DP[m]);
        }
    }
}
