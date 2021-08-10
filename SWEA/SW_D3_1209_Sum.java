package com.ssafy.solution;

import java.util.Scanner;

public class SW_D3_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();					// 테스트 케이스 번호
			int max = Integer.MIN_VALUE;			// 최대값
			int sum = 0;							// 합계
			int[][] arr = new int[100][100];
			
			// 2차원 배열
			// 행의 합 중 최대값 구하기
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					sum += arr[i][j];
				}
				if (max < sum) max = sum;
			}
			
			// 열의 합 중 최대값 구하기
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += arr[j][i];
				}
				if (max < sum) max = sum;
			}
			
			// 왼-오대각선의 합 중 최대값 구하기
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (i == j)	sum += arr[i][j];
				}
			}
			if (max < sum) max = sum;
			
			// 오-왼대각선의 합 중 최대값 구하기
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 99; j >= 0; j--) {
					if (i + j == 99) sum += arr[i][j];
				}
			}
			if (max < sum) max = sum;
			
			// 출력
			System.out.printf("#%d %d\n", tc, max);
		}
		sc.close();
	}
}
