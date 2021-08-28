import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2460_지능형기차2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;		// 최대 인원
		int total = 0;						// 기차에 사람 수
		for (int t = 0; t < 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			total -= Integer.parseInt(st.nextToken());
			total += Integer.parseInt(st.nextToken());
			// 최댓값 구하기
			if (total > max) max = total;
		}
		// 출력
		System.out.println(max);
	}
}
