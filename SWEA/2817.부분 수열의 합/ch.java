import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_2817 {
    static  int N, K;
    static int[] A;
    static int answer;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =null;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T ; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = new int[N];
            isSelected = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            recursion(0, 0);
            System.out.println("#" + t + " " + answer);
        }
    }

    private static void recursion(int cnt, int sum) {
        if(sum == K) {
            answer++;
            return;
        }
        if(cnt > N-1 || sum > K ) return;
        //자신 미포함
        recursion(cnt + 1, sum);
        //자신 포함
        recursion(cnt + 1, sum + A[cnt]);
    }
}
