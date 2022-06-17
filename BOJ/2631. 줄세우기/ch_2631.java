import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch_2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        int[] DP = new int[N];
        DP[0] = 1;

        for (int i = 1; i < N; i++) {
            DP[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) DP[i] = Math.max(DP[i], DP[j] + 1);
            }
            ans = Math.max(ans, DP[i]);
        }
        System.out.println(N - ans);
    }
}
