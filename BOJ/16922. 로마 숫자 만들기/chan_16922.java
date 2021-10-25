import java.util.Scanner;

public class chan_16922 {

    static int N, ans;
    static int[] rome;
    static int[] numbers;
    static boolean[] isSelected, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        isSelected = new boolean[4];
        sum = new boolean[1001]; // N개의 로마 숫자를 모두 합한 값이 겹치지 않는지 체크하기 위한 배열
        rome = new int[] { 1, 5, 10, 50 }; // 로마숫자 4가지
        comb(0, 0);
        System.out.println(ans);
    }

    private static void comb(int cnt, int lim) {
        // 기저조건
        if (cnt == N) {
            int curSum = 0;
            for (int i = 0; i < N; i++) {
                curSum += numbers[i];
            }
            // 이미 나온 합이면 리턴
            if (sum[curSum])
                return;
            // 이미 나온 합이 아니면 체크 후 개수 세고 리턴
            sum[curSum] = true;
            ans++;
            return;
        }

        // 각 자리별로 4개의 로마숫자가 올 수 있음
        for (int i = 0; i < 4; i++) {
            numbers[cnt] = rome[i];
            // 첫번째 자리를 뽑는 게 아니면, 이전에 뽑았던 숫자보다 작은 걸 뽑지 않기 위해 lim값 설정
            if (cnt > 0) {
                lim = numbers[cnt - 1];
            }
            // 백트래킹 - 이전에 뽑았던 숫자보다 작으면 다음 로마 숫자 뽑기
            if (numbers[cnt] < lim) {
                continue;
            }
            comb(cnt + 1, lim);
        }

    }

}
