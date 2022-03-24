import java.util.HashMap;

public class D7_없는숫자더하기 {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,6,7,8,0};
        int ans = solution(numbers);
        System.out.println(ans);

    }

    public static int solution(int[] numbers) {
        int answer = 0;
        // 검색을 위해
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], numbers[i]);
        }

        for (int i = 0; i < 10; i++) {
            // key 존재 여부에 따라 없는 숫자 더하기
            if(!map.containsKey(i)) answer += i;
        }

        return answer;
    }
}
