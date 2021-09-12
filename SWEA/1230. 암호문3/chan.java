import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_D3_1230_암호문3 {
	/**
	 * 1229. 암호문 2에서 리스트의 맨마지막에 추가하는 add 기능만 추가
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int codeLen = Integer.parseInt(br.readLine());	// 원본 암호문의 길이
			ArrayList<Integer> code = new ArrayList<>(codeLen);	// 암호문
			
			// 입력받기
			String[] data = br.readLine().split(" ");
			for (int i = 0; i < codeLen; i++) {
				code.add(Integer.parseInt(data[i]));
			}
			int N = Integer.parseInt(br.readLine());	// 명령어의 개수
			data = br.readLine().split(" ");
			int idx = 0;
			// 명령어의 개수만큼 기능 처리
			for (int i = 0; i < N; i++) {
				String f = data[idx++];	// 기능
				
				if (f.equals("I")) {	// 삽입일 때
					int x = Integer.parseInt(data[idx++]);	// x의 위치 바로 다음부터
					int y = Integer.parseInt(data[idx++]);	// y개의 숫자 
					for (int j = 0; j < y; j++) {
						code.add(x + j, Integer.parseInt(data[idx++]));	// 삽입은 덧붙일 숫자만큼 인덱스를 하나씩 뒤로 해줌
					}
				} else if (f.equals("D")) {	// 삭제일 때(D)
					int x = Integer.parseInt(data[idx++]);	// x의 위치 바로 다음부터
					int y = Integer.parseInt(data[idx++]);	// y개의 숫자 
					for (int j = 0; j < y; j++) {
						code.remove(x);	// 제거는 지우면 앞으로 당겨오니까 지울 인덱스는 그대로 x
					}
				} else { // 추가일 때
					int y = Integer.parseInt(data[idx++]);	// y개의 숫자 
					for (int j = 0; j < y; j++) {
						code.add(Integer.parseInt(data[idx++]));	// 제거는 지우면 앞으로 당겨오니까 지울 인덱스는 그대로 x
					}
				}
			}
			
			// 수정된 암호문의 처음 10개 항 출력하기
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();
		}
	}

}
