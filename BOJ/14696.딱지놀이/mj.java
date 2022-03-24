import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class W_14696_딱지놀이 {

    static int N;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            A = new int[N+1];
            B = new int[N+1];
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                int k = Integer.parseInt(st.nextToken());
                A[k]++;
            }
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < b; j++) {
                int k = Integer.parseInt(st.nextToken());
                B[k]++;
            }

            boolean winner = false;
            for (int j = N; j >= 0; j--) {
                if(A[j] == B[j]) continue;
                else if(A[j] > B[j]) {
                    winner = true;
                    sb.append("A\n");
                    break;
                }
                else {
                    winner = true;
                    sb.append("B\n");
                    break;
                }
            }

            if(!winner) sb.append("D\n");
        }

        System.out.println(sb.toString());
    }
}
