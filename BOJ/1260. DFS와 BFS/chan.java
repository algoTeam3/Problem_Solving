package com.ssafy.algoStudy0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요구사항 : 그래프를 DFS와 BFS로 탐색한 결과를 출력해라(단, 정점 번호가 작은 순으로 방문하기)
 */
public class BOJ_실버2_1260_DFS와BFS {
	
	static int N, M, V;	// 정점 개수, 간선 개수, 탐색 시작 정점 번호
	static boolean[][] adjMatrix;	// 인접 행렬
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		adjMatrix = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}	// 입력 받기 완료
		
		// dfs 실행
		boolean[] visited = new boolean[N + 1];
		dfs(V, visited);
		System.out.println();
		// bfs 실행
		bfs(V);
		
	}
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;	// 방문하기 전 방문체크
		System.out.print(current + " ");
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adjMatrix[current][i]) {	// 방문하지 않은 정점이고, 인접해잇는 정점이라면
				dfs(i, visited);						// 그 정점으로 가기
			}
		}
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		
		queue.offer(start);		// 시작 정점부터 큐에 넣고
		visited[start] = true;	// 방문 체크
		
		while(!queue.isEmpty()) {
			int current = queue.poll();		// 큐의 맨 앞의 애 꺼내기
			
			System.out.print(current + " ");
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adjMatrix[current][i]) {	// 방문하지 않은 정점이고, 인접해 있는 정점이라면,	
					queue.offer(i);							// 그 정점을 큐에 넣고 
					visited[i] = true;						// 방문 처리 하기
				}
			}
		}
	}

}
