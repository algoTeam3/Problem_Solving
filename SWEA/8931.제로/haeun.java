package com.ssafy.solution;

import java.util.Scanner;
import java.util.Stack;

public class SW_D3_8931_제로 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();					// 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();				// 정수의 수
			int total = 0;
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num == 0) stack.pop();		// 정수가 0일 경우 최근 정수 제거
				else stack.push(num);			// 가격을 stack에 담기
			}
			
			// 합계 구하기
			while (!stack.isEmpty()) total += stack.pop();
			// 출력
			System.out.printf("#%d %d\n", tc, total);
		}
		sc.close();
	}
}
