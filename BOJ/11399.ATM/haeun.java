import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 사람의 수
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] people = new int[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순으로 정렬
		Arrays.sort(people);
		// 인출하는 시간의 합 구하기
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (i > 0) {
				for (int j = 0; j < i; j++) {
					sum += people[j];
				}
			}
			sum += people[i];
		}
		// 출력
		System.out.println(sum);
	}
}
