import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] parr = new int[N];
		for (int i = 0; i < N; i++) {
			parr[i] = Integer.parseInt(st.nextToken());
		}
        // 입력 받기 완료

        // 필요한 시간의 합의 최소는 오름차순 정렬
		Arrays.sort(parr);

        // 걸리는 시간의 합 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				ans += parr[j];
			}
		}
		System.out.println(ans);
	}

}
