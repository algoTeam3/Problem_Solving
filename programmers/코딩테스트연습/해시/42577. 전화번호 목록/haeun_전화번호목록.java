import java.util.Arrays;
import java.util.HashSet;

public class programmers_lv2_전화번호목록 {

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
	}
	
	public static boolean solution(String[] phone_book) {
        HashSet<String> hash = new HashSet<>();
        // 정렬
        Arrays.sort(phone_book);
        
        for (String phone : phone_book) {
        	hash.add(phone);
        	
        	// 앞에서부터 번호를 하나씩 늘려가면서 접두사가 있는지 판단
        	for (int i = 0; i < phone.length(); i++) {
        		// 접두사 O
        		if (hash.contains(phone.substring(0, i))) {
        			return false;
        		}
        	}
        }
        // 접두사 X
        return true;
    }
}
