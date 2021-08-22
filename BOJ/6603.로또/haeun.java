import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6603_로또 {
	private static int[] arr, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			// 0이면 반복문 탈출
			if (str.equals("0")) break;
			String[] temp = str.split(" ");
			
			arr = new int[temp.length];					// K개 뽑기
			result = new int[6];						    // 6개를 고르는 경우의 수
			
			for (int i = 1; i < temp.length; i++) {
				arr[i] = Integer.parseInt(temp[i]);
			}
			// 조합
			comb(0, 1);
			// 빈 줄 출력
			System.out.println();
		}
	}
	
	// 조합
	private static void comb(int cnt, int start) {
		// 기저조건
		if (cnt == result.length) {
			// 출력
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			result[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
	}
}
