import java.util.Arrays;

/**
    rows x columns 크기의 행렬
    1부터 숫자가 row 한줄씩 순서대로 적혀있다
    직사각형 모양의 범위를 여러번 선택해, 테두리 부분에 있는 숫자들을 시계방향으로 회전
    각 회전은 x1,y1,x2,y2
 */
public class D10_행렬테두리회전하기 {

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        };
        int[] solution = solution(rows, columns, queries);
        System.out.println(Arrays.toString(solution));
    }

    /**
     * queries 하나만 본다면 x1행 y1열부터 y2열까지
     * y2열 x1행부터 x2행까지
     * x2행 y2열부터 y1열까지
     * y1행 x2행부터 x1행까지
     * @param rows
     * @param columns
     * @param queries
     * @return 위치가 바뀐 숫자들 중 가장 작은 숫자들을 순서대로 담은 배열 queries의 개수만큼
     */
    static int[][] map;

    private static void init(int rows, int columns){
        map = new int[rows+1][columns+1];
        int k = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = k++;
            }
        }
    }

    private static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        init(rows,columns);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = move(queries[i]);
        }

        return answer;
    }

    private static int move(int[] query) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int temp1 = 0, temp2 = 0;
        int min = Integer.MAX_VALUE;

        // x1행 y1열부터 y2열까지
        temp1 = map[x1][y2];
        for (int i = y2; i > y1; i--) {
            min = Math.min(min, map[x1][i]);
            map[x1][i] = map[x1][i-1];
        }

        // y2열 x1행부터 x2행까지
        temp2 = map[x2][y2];
        for (int i = x2; i > x1; i--) {
            min = Math.min(min, map[i][y2]);
            map[i][y2] = map[i-1][y2];
        }
        map[x1+1][y2] = temp1;

        // x2행 y2열부터 y1열까지
        temp1 = map[x2][y1];
        for (int i = y1; i < y2; i++) {
            min = Math.min(min, map[x2][i]);
            map[x2][i] = map[x2][i+1];
        }
        map[x2][y2-1] = temp2;

        // y1행 x2행부터 x1행까지
        for (int i = x1; i < x2; i++) {
            min = Math.min(min, map[i][y1]);
            map[i][y1] = map[i+1][y1];
        }
        map[x2-1][y1] = temp1;

        return min;
    }
}
