import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14696_딱지놀이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		// 라운드
		
		for (int cnt = 1; cnt <= N; cnt++) {
			// a딱지
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int aCnt = Integer.parseInt(st.nextToken());
			int[] aTemp = new int[aCnt];
			for (int i = 0; i < aCnt; i++) aTemp[i] = Integer.parseInt(st.nextToken());
			
			// b딱지
			st = new StringTokenizer(br.readLine(), " ");
			int bCnt = Integer.parseInt(st.nextToken());
			int[] bTemp = new int[bCnt];
			for (int i = 0; i < bCnt; i++) bTemp[i] = Integer.parseInt(st.nextToken());
			
			// 오름차순으로 정렬
			Arrays.sort(aTemp);
			Arrays.sort(bTemp);
			
			// 내림차순으로 정렬
			int[] a = new int[aCnt];
			int[] b = new int[bCnt];
			for (int i = aTemp.length - 1, j = 0; i >= 0; i--, j++) {
				a[j] = aTemp[i];
			}
			for (int i = bTemp.length - 1, j = 0; i >= 0; i--, j++) {
				b[j] = bTemp[i];
			}
			
			// 모양이 더 적은 갯수만큼 반복
			int index = 0;
			int len = a.length < b.length ? a.length : b.length;
			while (index != len) {
				if (a[index] > b[index]) {
					System.out.println("A");
					break;
				} else if (a[index] < b[index]) {
					System.out.println("B");
					break;
				}
				// 같은 모양이면 다음값 탐색
				else {
					index++;
				}
				// 만일 끝까지 순회했다면
				if (index == len) {
					// A의 모양이 더 남아있으면 A승리
					if (a.length > index) System.out.println("A");
					// B의 모양이 더 남아있으면 B승리
					else if (b.length > index) System.out.println("B");
					// A와 B의 모양이 동일하다면 무승부
					else System.out.println("D");
					break;
				}
			}
		}
	}
}
