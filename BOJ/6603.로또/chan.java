import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

public class chan {

	static int[] input, numbers;
	static int k;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader("7 1 2 3 4 5 6 7\r\n" + 
				"8 1 2 3 5 8 13 21 34\r\n" + 
				"0"));
		
		while(true) {
			String[] data = br.readLine().split(" ");
			// 0이 입력되면 프로그램 종료
			if (data[0].equals("0")) break;
			k = Integer.parseInt(data[0]);
			input = new int[k];
			numbers = new int[6];
			for (int i = 0; i < k; i++) {
				input[i] = Integer.parseInt(data[i + 1]);
			}
			selectNumbers(0, 0);
			System.out.println();
		}
	}
	// k개의 숫자에서 6개의 수를 뽑는 모든 경우의 수 출력하기
	static void selectNumbers(int cnt, int start) {
		if (cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < k; i++) {
			numbers[cnt] = input[i];
			selectNumbers(cnt + 1, i + 1);
		}
	}

}
