class chan {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 행, 열 인덱스 그대로 사용하기 위해 크기 1 증가
        int[][] map = new int[rows + 1][columns + 1];
        int cnt = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                map[i][j] = cnt++;
            }
        }
        
        
        for (int i = 0; i < queries.length; i++) {
            int startX = queries[i][0];
            int startY = queries[i][1];
            int endX = queries[i][2];
            int endY = queries[i][3];
            
            int temp = map[startX][startY]; // 첫번째 시작 값을 따로 빼놓기
            int x = startX; int y = startY; 
            int change = 1;
            int min = temp;
            
            // 증가되는 행,열 그리고 감소되는 행,열이 반복됨
            for (int j = 0; j < 2; j++) {
                int nx = x;
                int ny = y;
                // 증가/감소되는 행
                for (int k = startX; k < endX; k++) {
                    nx += (1 * change);
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                    min = min > map[x][y] ? map[x][y] : min;
                }
                // 증가/감소되는 열
                for (int k = startY; k < endY; k++) {
                    ny += (1 * change);
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                    min = min > map[x][y] ? map[x][y] : min;
                }
                // 감소시키기 위해 음수로 만들어줌
                change *= -1;
            }
            map[startX][startY + 1] = temp; // 처음에 빼놓은 시작값으로 채우기

            answer[i] = min;
        }
        return answer;
    }
}