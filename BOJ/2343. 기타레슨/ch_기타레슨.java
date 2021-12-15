import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ch_기타레슨 {
    static int N, M, left, right;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        binarySearch();

        System.out.println(left);
    }

    private static void binarySearch() {
        int mid, sum, cnt;
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0;
            cnt = 0;

            for (int i = 0; i < N; i++) {
                if (sum + arr[i] > mid){
                    sum = 0;
                    cnt++;
                }
                sum += arr[i];
            }

            if (sum > 0) cnt++;

            if (cnt <= M) right = mid - 1;
            else left = mid + 1;
        }
    }
}
