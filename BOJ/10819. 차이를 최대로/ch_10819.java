
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * BOJ_10819_차이를최대로
 * |A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 *  순열로 접근해보자
 */
public class ch_10819 {
    static int N;
    static int[] numbers;
    static int[] selected;
    static boolean[] visited;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        solve(0);
        System.out.println(ans);
    }

    private static void solve(int cnt) {
        if(cnt == N){
            ans = Math.max(sum(), ans);
            return;
        }

        for (int i = 0; i < N; i++) {
            // 방문 체크
            if (visited[i]) continue;
            selected[cnt] = numbers[i];
            visited[i] = true;
            solve(cnt + 1);
            visited[i] = false;
        }
    }

    // 합계 구하기
    private static int sum() {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }
}
