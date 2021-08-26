import java.util.Scanner;

public class chan {

	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int tc = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + tc + " " + pow(N, M));
		}
	}

	private static int pow(int n, int m) {
		if (m == 0) return 1;
		return n * pow(n, m - 1);
	}

}
