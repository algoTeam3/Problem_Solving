import java.util.Scanner;

public class chan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int i = 0;
		int end = 1;
		while (true) {
			end = end + (6 * i);
			if (N <= end) break;
			i++;
		}
		System.out.println(i + 1);
		sc.close();
	}

}
