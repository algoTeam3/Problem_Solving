/**
 * 문자열에서 영단어를 찾아서 모두 숫자로 바꿔주자
 */
public class D4_숫자문자열과영단어 {

        public static void main(String[] args) {
                String s = "one4seveneight";
                int solution = solution(s);
                System.out.println(solution);
        }

        public static int solution(String s) {
                int answer = 0;
//                풀이 1
//                s = s.replaceAll("one", "1");
//                s = s.replaceAll("two", "2");
//                s = s.replaceAll("three", "3");
//                s = s.replaceAll("four", "4");
//                s = s.replaceAll("five", "5");
//                s = s.replaceAll("six", "6");
//                s = s.replaceAll("seven", "7");
//                s = s.replaceAll("eight", "8");
//                s = s.replaceAll("nine", "9");
//                s = s.replaceAll("zero", "0");

                String[] nums = {"1","2","3","4","5","6","7","8","9","0"};
                String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};

                for(int i = 0; i < nums.length; i++){
                        s = s.replaceAll(words[i], nums[i]);
                }
                return Integer.parseInt(s);
        }
}