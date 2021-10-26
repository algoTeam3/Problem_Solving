import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ch_16922 {
    static int N;
    static int[] number = {1, 5, 10, 50};
    static boolean[] visited;
    static int[] answer;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[10000];
        answer = new int[N];
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int cnt, int start) {
        if (cnt == N){
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += answer[i];
            }
            
            // 같은 값인지 체크
            if(!visited[sum]) {
                ans++;
                visited[sum] = true;
            }
            return;
        }
        for (int i = start; i < number.length; i++) {
            answer[cnt] = number[i];
            solve(cnt + 1, i);
        }
    }
}
