
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chan {

	static int[][] wheel;
	static int T;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		wheel = new int[T + 1][8];
		for (int t = 1; t <= T; t++) {
			String[] data = br.readLine().split("");
			for (int i = 0; i < 8; i++) {
				wheel[t][i] = Integer.parseInt(data[i]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			if (num - 1 >= 1) {
				left(num - 1, -dir);
			}
			if (num + 1 <= T) {
				right(num + 1, -dir);
			}
			rotate(wheel[num], dir);
		}
		
		int answer = 0;
		for (int t = 1; t <= T; t++) {
			if (wheel[t][0] == 1) answer++;
		} 
		System.out.println(answer);
	}

	private static void left(int num, int dir) {
		if (num == 0) return;
		if (wheel[num][2] == wheel[num + 1][6]) return;
		left(num - 1, -dir);
		rotate(wheel[num], dir);
	}

	private static void right(int num, int dir) {
		if (num > T) return;
		if (wheel[num - 1][2] == wheel[num][6]) return;		
		right(num + 1, -dir);
		rotate(wheel[num], dir);
	}
	
	private static void rotate(int[] arr, int dir) {
		if (dir == -1) {
			int temp = arr[0];
			for (int i = 0; i < 7; i++) {
				arr[i] = arr[i + 1];
			}
			arr[7] = temp;
		} else {
			int temp = arr[7];
			for (int i = 6; i >= 0; i--) {
				arr[i + 1] = arr[i];
			}
			arr[0] = temp;
		}
	}
}
