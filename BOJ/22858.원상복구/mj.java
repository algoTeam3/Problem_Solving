import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class W_22858_원상복구 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] S = new int[N+1];
        int[] D = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] ans = solution(S, D, N, K);
        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] solution(int[] S, int[] D, int N, int K) {

        for (int k = 0; k < K; k++) {
            int[] P = new int[N+1];
            for (int i = 1; i <= N; i++) {
                P[D[i]] = S[i];
            }
            S = Arrays.copyOf(P, N+1);
        }

        return S;
    }
}
