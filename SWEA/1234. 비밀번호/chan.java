import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class chan {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			String[] data = br.readLine().split(" ");
			int N = Integer.parseInt(data[0]);
			char[] input = data[1].toCharArray();
			ArrayList<Integer> list = new ArrayList<>(N);	// 같으면 바로 소거해서 문자열의 길이가 변할 수 있게 ArrayList로 선언
			for (int n = 0; n < N; n++) {
				list.add(input[n] - '0');
			}
			
			// 처음 두 숫자부터 차례로 비교(비교할 인덱스 초기화)
			int aIdx = 0;
			int bIdx = 1;
			while(true) {
				// 인덱스가 리스트 범위를 넘어가면 종료
				if (aIdx < 0 || bIdx >= list.size()) break;
				// 범위 이내인데 두 수가 다르다면 바로 다음 수끼리 비교
				if (list.get(aIdx) != list.get(bIdx)) {
					aIdx++;
					bIdx++;
					continue;
				}
				// 두 수가 같다면 소거하기
				while(list.get(aIdx) == list.get(bIdx)) {
					list.remove(aIdx);
					list.remove(aIdx);	// 소거하면 뒤에게 바로 당겨져서 소거할 인덱스는 aIdx와 같음
					// 소거한 인덱스가 문자열의 맨 앞의 수 였거나 맨 뒤의 수였을 때 비교 끝 
					if (aIdx - 1 < 0 || bIdx >= list.size()) break;
					// 소거된 번호쌍의 좌우번호를 비교할 숫자는 소거한 것을 고려해서 인덱스를 1씩 줄여줬을 때의 숫자임
					aIdx--;
					bIdx--;
				}
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

}
