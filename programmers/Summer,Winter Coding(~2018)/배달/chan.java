/**
 * 요구사항 : 마을의 개수 N, 각 마을을 연결하는 도로의 정보road[][], 음식 배달이 가능한 시간 K가 주어졌을 때, 
 * 1번 마을에 있는 음식점이 음식 주문을 받을 수 있는 마을의 개수를 구해라
 */
class chan {
    /**
    * 마을의 개수 N, 각 마을을 연결하는 도로 정보 road[][], 음식 배달이 가능한 시간 K
    */
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] d = new int[N + 1][N + 1];  // 인덱스를 1부터 시작하기 위해 N+1 크기로 초기화하기
        // 처음 2차원 배열 초기화 
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) { // 같은 마을 안에서 걸리는 시간은 경유할 필요도 없이 0으로 초기화
                    d[i][j] = 0;
                    continue;
                }
                d[i][j] = 500000; // 음식 배달이 가능한 시간의 최댓값으로 초기화
            }
        }
        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if (c < d[a][b])  // 기존 배열의 값보다 작다면 도로를 지나는데 걸리는 시간을 변경
                d[a][b] = d[b][a] = c;
        }
       // 플로이드 알고리즘
        for (int k = 1; k <= N; k++) {  // 경유지
            for (int i = 1; i <= N; i++) {  // 출발지
                for (int j = 1; j <= N; j++) { // 도착지
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
        
        // 1번 마을의음식점이 K이하의 시간에 배달이 가능한 마을의 개수 세기
        for (int i = 1; i <= N; i++) {
            if (d[1][i] <= K) answer++;
        }
        return answer;
    }
}
