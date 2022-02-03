class chan_60057 {
    public int solution(String s) {
        int count = 1;  // 압축 단어 앞에 붙일 압축된 숫자
        int minLen = s.length();
        String a = "";
        String b = "";
        StringBuilder compareStr = new StringBuilder();
        
        // 자르는 단위
        for(int j = 1; j < s.length() / 2 + 1; j++) {
            for(int i = j; i < s.length(); i+=j) {
                a = s.substring(i-j, i);
                
                //마지막 비교 substring을 할 때는 범위를 넘으면 안됨
                if(i+j >= s.length())
                    b = s.substring(i);
                else
                    b = s.substring(i, i+j);
                //a와 b가 압축이 되는지
                if(a.equals(b))
                    count++;
                else if(!a.equals(b) || (i+j >= s.length())) {
                    if(count==1) {
                        compareStr.append(a);
                    }
                    else{
                        compareStr.append(Integer.toString(count));
                        compareStr.append(a);
                    }
                    count = 1;
                }
                        
            }
            
            //자르고 마지막에 남는 문자열은 그대로 붙여주기
            if (s.length() % j != 0)
                compareStr.append(s.substring(s.length()-(s.length() % j)));
            else {
                if(count != 1)
                    compareStr.append(Integer.toString(count));
                compareStr.append(s.substring(s.length()-j));
            }
            
            //최소 길이 문자열인지 비교하기
            if(compareStr.length() < minLen)
                minLen = compareStr.length();
            
            compareStr.setLength(0);
            count = 1;
        }
        
        return minLen;
    }
}