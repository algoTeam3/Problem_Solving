import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class chan {

	static int N, K, totalCnt;
	static int[] arr;
	static boolean[] isSelected;	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] data = br.readLine().split(" ");
			N = Integer.parseInt(data[0]);
			K = Integer.parseInt(data[1]);
			totalCnt = 0;		// 합이 K가 되는 경우의 수 카운팅
			arr = new int[N];	// N개의 수 저장할 배열
			isSelected = new boolean[N];	// N개의 수 각각의 포함 여부를 저장할 부분집합 크기 초기화
			
			data = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(data[i]);
			}
			
			getSubset(0);
			
			System.out.println("#" + t + " " + totalCnt);
		}
	}

	public static void getSubset(int cnt) {
		// 기저 조건
		if (cnt == N) {
			int sum = 0;	// 부분 집합의 합을 구할 변수 선언
			for (int i = 0; i < N; i++) {		
				// i번째 변수가 선택되었으면 sum에 합하기
				if (isSelected[i]) sum += arr[i];
			}
			
			// 부분집합의 합이 K일 때 카운팅
			if (sum == K) totalCnt++;
			
			return;
		}
		
		// 해당 원소 포함
		isSelected[cnt] = true;
		getSubset(cnt + 1);
		
		// 해당 원소 미포함
		isSelected[cnt] = false;
		getSubset(cnt + 1);
		
	}
}
