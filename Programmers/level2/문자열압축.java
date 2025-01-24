package level2;

public class 문자열압축 {
    private int compression (int len, String s) {
        StringBuilder sb = new StringBuilder();
        String s1 = s.substring(0, len);
        int count = 1;

        for (int i = len; i < s.length(); i += len) {
            String s2 = s.substring(i, Math.min(i + len, s.length()));

            if (s1.equals(s2))
                ++count;
            else {
                if (count != 1)
                    sb.append(count).append(s1);
                else
                    sb.append(s1);
                s1 = s2;
                count = 1;
            }
        }
        if (count != 1)
            sb.append(count).append(s1);
        else
            sb.append(s1);

        return sb.length();
    }

    public int solution (String s) {
        int answer = 1000;

        for (int i = 1; i <= s.length() / 2; ++i)
            answer = Math.min(answer, compression(i, s));
        if (s.length() == 1)
            answer = 1;
        return answer;
    }
}
