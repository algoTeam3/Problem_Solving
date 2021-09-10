import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_D3_1229_암호문2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());		// 원본 암호문의 길이
			int[] arr = new int[N];							// 원본 암호문
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int command = Integer.parseInt(br.readLine());	// 명령어의 개수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < command; i++) {
				String com = st.nextToken();
				// 삽입
				if (com.equals("I")) {
					int index = Integer.parseInt(st.nextToken());	// 위치
					int count = Integer.parseInt(st.nextToken());	// 개수
					int[] temp = new int[N];
					// 삽입 뒤에 위치하는 요소들 따로 저장
					for (int j = index, k = 0; j < N-count; j++, k++) {
						temp[k] = arr[j];
					}
					// 삽입
					for (int j = index; j < index+count; j++) {
						if (j < N) arr[j] = Integer.parseInt(st.nextToken());
						else {
							int trash = Integer.parseInt(st.nextToken());
						}
					}
					// 삽입 뒤에 요소 붙이기
					for (int j = index+count, k = 0; j < N; j++, k++) {
						arr[j] = temp[k];
					}
				}
				// 삭제
				else if (com.equals("D")) {
					int index = Integer.parseInt(st.nextToken());	// 위치
					int count = Integer.parseInt(st.nextToken());	// 개수
					int[] temp = new int[N];
					// 삭제 뒤에 위치하는 요소들 따로 저장
					for (int j = index+count, k = 0; j < N; j++, k++) {
						temp[k] = arr[j];
					}
					// 삭제
					for (int j = index, k = 0; j < N; j++, k++) {
						arr[j] = temp[k];
					}
				}
			}
			// 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", arr[i]);
			}
			System.out.println();
		}
	}
}
