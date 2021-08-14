import java.util.Scanner;

// 알고리즘스터디
public class SW_D3_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt(); 			// 지역의 길이
			int[] arr = new int[len];
			
			// 빌딩 채우기
			for (int i = 0; i < len; i++) {
				arr[i] = sc.nextInt();
				// 예외처리
				if (arr[i] > 255) return;
			}
			 
			int total = 0;
			
			// 빌딩들을 순회하면서 좌우 2칸 공백 측정
			for (int i = 2; i < len - 2; i++) {
				// 조망권 확보를 위한 공백 측정
				int cnt = 0;
				int max = -1;
				for (int j = -2; j <= 2; j++) {
					// 자신 제외
					if (j == 0) continue;
					// 자신을 제외한 빌딩중 가장 높은 빌딩을 max에 저장
					if (max < arr[i+j]) max = arr[i+j];
					// 조망권이 확보될 때
					if (arr[i] - arr[i+j] >= 1) {
						cnt++;
					}
				}
				// 좌우 2칸 공백을 만족할 때, 조망권을 확보한 세대를 total에 합산
				if (cnt == 4) {
					total += arr[i] - max;
				}
			}
			System.out.printf("#%d %d\n", tc, total);
		}
	}
}
