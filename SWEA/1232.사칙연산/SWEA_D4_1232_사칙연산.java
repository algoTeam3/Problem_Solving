package com.ssafy.algoStudy0914;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 요구사항 : 사칙연산과 양의 정수로 구성된 이진트리가 주어질 때 연산의 결과를 구하기
 * 
 * 해결한 과정 : 
 * 입력으로 자식들의 정점번호까지 들어오면
 * 그 정점은 부모 정점으로, 연산자이다.
 * 그래서, 왼쪽 자식과 오른쪽 자식을 자신의 연산자로 연산해주고
 * 연산 결과를 자신의 정점에 다시 담는다.
 * 
 * 그렇게 계산한 최종 연산의 결과는 루트 정점에 담기게 된다.
 * 
 */
public class SWEA_D4_1232_사칙연산 {
	static int N, ans; // 정점의 총 수, 연산의 결과
	static String[][] input;	// 정점별 정점 정보를 담을 이차원배열
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/com/ssafy/algoStudy0914/input1232.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			// 입력받기
			N = Integer.parseInt(br.readLine());
			input = new String[N + 1][4];
			for (int i = 1; i <= N; i++) {
				String[] data = br.readLine().split(" ");
				
				for (int j = 0; j < 2; j++) {
					input[i][j] = data[j];
				}
				if (data.length == 4) {
					for (int j = 2; j < 4; j++) {
						input[i][j] = data[j];
					}
				}
			} // 입력받기 완료
			
			// 자식 정점을 가진 제일 뒤의 정점부터 차례로 연산을 해주면서 루트까지 온다.
			for (int i = input.length - 1; i > 0; i--) {
				if (input[i][2] != null) {	// 자식 정점이 있으면
					operation(i);	// 연산하기
				}
			}
			
			int ans = (int)Double.parseDouble(input[1][1]);	// 최종 결과값은 정수부만 출력한다
			System.out.println("#" + t + " " + ans);
		}
	}
	private static void operation(int index) {
		// 실수연산으로 해야하므로 실수로 변환
		double a = Double.parseDouble(input[Integer.parseInt(input[index][2])][1]);
		double b = Double.parseDouble(input[Integer.parseInt(input[index][3])][1]);
		double result = 0;
		// 4가지 연산자 별로 연산 수행
		switch(input[index][1].charAt(0)) {
		case '+':
			result = a + b; break;
		case '-':
			result = a - b; break;
		case '*':
			result = a * b; break;
		case '/':
			result = a / b; break;
		}
		input[index][1] = result + "";	// 문자열 배열이므로 문자열로 저장함
	}

}
