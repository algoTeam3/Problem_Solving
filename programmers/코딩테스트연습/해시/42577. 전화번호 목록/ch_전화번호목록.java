import java.util.HashMap;

public class ch_전화번호목록 {
    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> hash = new HashMap<>();

        for(int i = 0; i < phone_book.length; i++){
            hash.put(phone_book[i], i);
        }

        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(hash.containsKey(phone_book[i].substring(0, j))){
                    return false;
                }
            }
        }
        return true;
    }
}
