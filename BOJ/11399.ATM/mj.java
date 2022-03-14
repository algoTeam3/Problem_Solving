import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W_11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(P);
        int[] sum = new int[N];
        sum[0] = P[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1]+P[i];
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += sum[i];
        }

        System.out.println(ans);
    }
}
