import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW_D3_1230_암호문3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());				// 원본 암호문의 길이
			ArrayList<Integer> pw = new ArrayList<>();				// 원본 암호문
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				pw.add(Integer.parseInt(st.nextToken()));
			}
			
			int command = Integer.parseInt(br.readLine());			// 명령어의 개수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < command; i++) {
				String com = st.nextToken();						// 명령어
				// 삽입
				if (com.equals("I")) {
					int index = Integer.parseInt(st.nextToken());	// 인덱스
					int count = Integer.parseInt(st.nextToken());	// 개수
					while (count-- > 0) pw.add(index++, Integer.parseInt(st.nextToken()));
				}
				// 삭제
				else if (com.equals("D")) {
					int index = Integer.parseInt(st.nextToken());	// 인덱스
					int count = Integer.parseInt(st.nextToken());	// 개수
					while (count-- > 0) pw.remove(index);
				}
				// 추가
				else if (com.equals("A")) {
					int count = Integer.parseInt(st.nextToken());	// 개수
					while (count-- > 0) pw.add(Integer.parseInt(st.nextToken()));
				}
			}
			
			// 출력
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.printf("%d ", pw.get(i));
			}
			System.out.println();
		}
	}
}
