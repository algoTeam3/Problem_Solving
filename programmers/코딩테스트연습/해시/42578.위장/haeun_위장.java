import java.util.HashMap;

public class programmers_lv2_위장 {

	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}));
	}

	public static int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> category = new HashMap<>();
        for (String[] cloth : clothes) {
        	// 해당 종류가 처음일 때
        	if (category.get(cloth[1]) == null) category.put(cloth[1], 1);
        	// 해당 종류가 이미 존재할 때
        	else category.put(cloth[1], category.get(cloth[1]) + 1);
        }
        
        // 서로 다른 옷의 조합의 수 구하기
    	for (Integer cnt : category.values()) {
    		answer *= cnt + 1;
    	}
        
    	// 아예 안입는 경우 제외
        return answer - 1;
    }
}
