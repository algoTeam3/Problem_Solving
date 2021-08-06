public class chan {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			long N = sc.nextInt();	// 층의 번호
			
			long right = N * N * 2 - 1;		// 홀수 피라미드 각 층의 제일 오른쪽 숫자 구하는 규칙
			long left = right - 2 * (N * 2 - 2);	// 층을 이루는 숫자의 개수에 곱하기 2를 구해서 right에서 뺀 것이 맨 왼쪽 숫자임
			// N이 1일 때만 규칙이 적용되지 않는다.
			if (N == 1) {
				left = right = 1;
			}
			System.out.printf("#%d %d %d%n", t, left, right);
		}
		sc.close();
	}
}
// 계차수열 규칙 찾아서 반복문 돌렸으나 제약조건(1<=N<=10^9)때문에 안됨.(테케 4개만 정답)
// 반복문 안쓰는 규칙 찾아서 left, right 찾았지만 int 타입으로 생성했어서 안됨(테케 6개 정답)
// int 형은 대략 +-21억 정도인데 층만 최댓값이 10억이니 표현 범위가 부족!
// ==> long(8바이트) 타입을 써야함