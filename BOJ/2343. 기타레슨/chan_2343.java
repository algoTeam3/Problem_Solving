import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 요구사항 : 총 N개의 강의를 같은 크기의 M개의 블루레이에 담으려고 할 때, 가능한 블루레이의 크기 중 최소를 구해라
 * 
 * 이분탐색 : 블루레이의 크기를 이분탐색하며 찾아야한다.
 * @author chaeu
 *
 */
public class chan_2343 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		int start = 0, end = 0;	// start는 최소 블루레이 크기, end는 최대 블루레이 크기
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (start < arr[i]) start = arr[i];
			end += arr[i];
		}
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int sum = 0;	// 한 그룹 내의 합을 구할 변수
			int count = 0;	// 그룹 수
			// 앞에서부터 차례로 더하다가 mid보다 커지기 전까지의 수들을 한 그룹으로 묶기
			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > mid) {
					sum = 0; 
					count++;
				}
				sum += arr[i];
			}
			if (sum > 0) count++;	// 마지막 그룹 세기
			if (count <= M) end = mid - 1;	
			else start = mid + 1;
		}
		System.out.println(start);
	}
}
