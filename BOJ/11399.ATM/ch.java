package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_S3_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int[] P = new int[T];
        st = new StringTokenizer(br.readLine());
        for (int t = 0; t < T; t++) {
            P[t] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);
        int sum = 0;
        for (int i = 0; i < P.length; i++) {
            sum += (P.length - i) * P[i];
        }
        System.out.println(sum);
    }
}
