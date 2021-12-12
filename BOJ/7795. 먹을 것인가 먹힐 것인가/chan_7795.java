import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chan_7795 {
	static int[] b;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ans = 0;
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] a = new int[N];
			b = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(b);
			// A의 원소 하나씩을 B와 크기비교를 위한 이분탐색
			for (int i = 0; i < N; i++) {
				ans += binarySearch(a[i]);
			}
			System.out.println(ans);
		}
	}

	// 이분탐색
	private static int binarySearch(int key) {
		int start = 0;
		int end = b.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (b[mid] < key) start = mid + 1;
			else end = mid - 1;
		}
		if (start > end) return start;	// key보다 큰 b 원소의 개수는 start
		return 0;	// key보다 작은 b 원소가 없을 때
	}

}
