import java.util.Scanner;

public class BOJ_9996_한국이그리울땐서버에접속하지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();					// 파일의 개수
		String pattern = sc.next();				// 패턴
		// 패턴의 시작과 끝 추출
		int idx = pattern.indexOf("*");
		String start = pattern.substring(0, idx);
		String end = pattern.substring(idx+1, pattern.length());
		
		for (int i = 1; i <= N; i++) {
			String file = sc.next();
			
			// 만일 file 문자열의 길이가 패턴의 길이보다 작다면 "NE" 출력
			if (file.length() < pattern.length()-1) {
				System.out.println("NE");
				continue;
			}
			
			// 패턴 일치
			if (file.substring(0, start.length()).equals(start)
					&& file.substring(file.length()-end.length(), file.length()).equals(end)) {
				System.out.println("DA");
				continue;
			}
			
			// 패턴 불일치
			System.out.println("NE");
		}
		sc.close();
	}
}
