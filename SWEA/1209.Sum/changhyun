package com.ssafy.algoTeam3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_D3_1209_Sum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int max = -1;
			int sum = 0;
			
			// 맵 입력
			int[][] map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 가로 
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[i][j];
				}
				max = Math.max(max, sum);
			}
			// 세로
			for (int i = 0; i < 100; i++) {
				sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += map[j][i];
				}
				max = Math.max(max, sum);
			}
			//우측대각선
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += map[i][i];
			}
			max = Math.max(max, sum);
			
			//좌측대각선
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += map[i][99-i];
			}
			max = Math.max(max, sum);

			System.out.println("#" + t + " " + max);
		}
	}

}
