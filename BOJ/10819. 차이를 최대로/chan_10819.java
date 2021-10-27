import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan_10819 {
    static int N, ans;
    static int[] arr, numbers;
    static boolean[] isSelected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N]; // 받은 입력을 담을 배열
        numbers = new int[N]; // 순열로 N개를 뽑아서 담을 배열
        isSelected = new boolean[N]; // 뽑았던 수인지 체크하기 위한 배열
        ans = 0; // 가능한 식의 최댓값
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // 입력받기 완료

        solve(0);
        System.out.println(ans);
    }

    private static void solve(int cnt) {
        // 기저조건
        if (cnt == N) {
            int sum = 0;
            for (int i = 1; i < cnt; i++) {
                sum += Math.abs(numbers[i - 1] - numbers[i]);
            }
            if (sum > ans)
                ans = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isSelected[i])
                continue;

            numbers[cnt] = arr[i];
            isSelected[i] = true;

            solve(cnt + 1);
            isSelected[i] = false;
        }

    }

}
