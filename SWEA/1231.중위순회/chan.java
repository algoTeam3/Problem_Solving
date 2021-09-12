import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class chan {
	static int N; 
	static char[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			// 입력받기
			N = Integer.parseInt(br.readLine());
			input = new char[N + 1];
			for (int i = 1; i <= N; i++) {
				String[] data = br.readLine().split(" ");
				input[i] = data[1].charAt(0);
			}
			// 입력받기 완료
			
			System.out.print("#" + t + " " );
			recur(1);	// 루트노드부터 재귀
			System.out.println();
		}
	}

	private static void recur(int i) {
		if (i > N) {
			return;
		}
		recur(i * 2);	// 왼쪽 자식 먼저 재귀
		System.out.print(input[i]); // 자신 출력하기
		recur(i * 2 + 1);	// 오른쪽 자식 재귀
	}
	

}
