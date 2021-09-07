import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SW_D4_1222_계산기1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int len = Integer.parseInt(br.readLine());	// 문자열의 길이
			String cal = br.readLine();					        // 계산식
			int result = 0;
			
			// 후위 표기식으로 계산
			for (int i = 0; i < len; i++) {
				if (cal.charAt(i) == '+' || i == len-1) {
					// 마지막 값 저장
					if (i == len-1) queue.offer(cal.charAt(i)-'0');
					// 계산할 값이 하나라면 생략
					if (queue.size() == 1) continue;
					// 계산
					int num1 = queue.poll();
					int num2 = queue.poll();
					result = num1 + num2;
					queue.offer(result);
				}
				// 숫자라면 queue에 저장
				else queue.offer(cal.charAt(i)-'0');
			}
			
			// 출력
			System.out.printf("#%d %d\n", tc, result);
		}
	}
}
