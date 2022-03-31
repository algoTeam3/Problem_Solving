import java.util.Arrays;

public class D9_K번째수 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] sol = solution(array, commands);
        System.out.println(Arrays.toString(sol));
    }

    static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int j = 0; j < commands.length; j++) {
            int[] command = commands[j];
            int start = command[0]-1; // 1
            int end = command[1]-1; // 4
            int cnt = command[2]-1; // 2

            int[] newArr = new int[end-start+1];
            int k = 0;
            for (int i = start; i <= end ; i++) {
                newArr[k++] = array[i];
            }
            // 5,2,6,3 -> 2,3,5,6
            Arrays.sort(newArr);
            answer[j] = newArr[cnt];
        }

        return answer;
    }
}
