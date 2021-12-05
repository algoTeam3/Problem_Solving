class chan {
    public int solution(String s) {
        String[] numberToString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        StringBuffer answer = new StringBuffer();
		StringBuffer temp = new StringBuffer();
        
        for (int i = 0; i < s.length(); i++) {
			// 숫자일 때는 반환하기 위해 answer에 추가
			if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' < 10) {
				answer.append(s.charAt(i));
			}
            // 숫자가 아닐 때는 연속된 문자열이 영단어에 포함되는지 확인
			else {
				temp.append(s.charAt(i));
				for (int j = 0; j < numberToString.length; j++) {
                    // 숫자 문자열이 영단어에 있을 때는 해당하는 숫자를 answer에 추가
					if (numberToString[j].equals(temp.toString())) {
						answer.append(j);
						temp.setLength(0);
					}
				}
				
			}
		}
        // 문자열 형태이므로 숫자로 반환
        return Integer.parseInt(answer.toString());
    }
}