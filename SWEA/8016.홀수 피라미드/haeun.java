package com.ssafy.solution;

import java.util.Scanner;

public class SW_D3_8016_홀수피라미드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();						// 테스트 케이스의 수
		
		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextInt(); 					// N층
			
			long left = 2*(N-1)*(N-1) + 1;
			long right = 2*N*N - 1;
			
			// 출력
			System.out.printf("#%d %d %d\n", tc, left, right);
		}
		sc.close();
	}
}
