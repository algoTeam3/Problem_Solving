import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ch_2467 {
    static int N, a = 0, b = 0, min = Integer.MAX_VALUE;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                int sum = Math.abs(arr[i] + arr[mid]);

                if (min > sum) {
                    min = sum;
                    a = arr[i];
                    b = arr[mid];
                }
                if (arr[mid] == -arr[i]) break;
                else if (arr[mid] < -arr[i]) left = mid + 1;
                else right = mid - 1;
            }
        }
        System.out.println(a + " " + b);
    }
}
