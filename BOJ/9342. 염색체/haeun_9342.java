import java.util.Scanner;

public class BOJ_9342_염색체 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();		        // 테스트 케이스의 수
		String rule = "^[A-F]?A+F+C+[A-F]?$";	// 규칙
		
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next();	        // 염색체 문자열
			
			// 출력
			if (str.matches(rule)) System.out.println("Infected!");
			else System.out.println("Good");
		}
		sc.close();
	}
}
