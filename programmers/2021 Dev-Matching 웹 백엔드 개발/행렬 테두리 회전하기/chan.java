class chan {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
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
            
            int temp = map[startX][startY];
            int x = startX; int y = startY; 
            int change = 1;
            int min = temp;
            for (int j = 0; j < 2; j++) {
                int nx = x;
                int ny = y;
                for (int k = startX; k < endX; k++) {
                    nx += (1 * change);
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                    min = min > map[x][y] ? map[x][y] : min;
                }
                for (int k = startY; k < endY; k++) {
                    ny += (1 * change);
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                    min = min > map[x][y] ? map[x][y] : min;
                }
                
                change *= -1;
            }
            map[startX][startY + 1] = temp;

            answer[i] = min;
        }
        return answer;
    }
}