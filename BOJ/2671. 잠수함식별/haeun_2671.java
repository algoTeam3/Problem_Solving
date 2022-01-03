import java.util.Scanner;

public class BOJ_2671_잠수함식별 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String sound = sc.next();		// 잠수함의 소리
		String pattern = "(100+1+|01)+";	// 패턴
		
		// 출력
		if (sound.matches(pattern)) System.out.println("SUBMARINE");
		else System.out.println("NOISE");
		
		sc.close();
	}
}
