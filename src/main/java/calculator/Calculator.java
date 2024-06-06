package calculator;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private List<Integer> nums;

    public int calculate(String str) throws Exception {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        String[] splitedStr = splitString(str);
        return addAll(splitedStr);
    }

    int addAll(String[] splitedStr) {
        int sum = 0;
        for (String num : splitedStr) {
            checkValidNumber(num);
            sum += Integer.parseInt(num);
        }

        return sum;
    }

    String[] splitString(String str) {
        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(str);

        if (matcher.find()) {
            String delimiter = matcher.group(1);
            return matcher.group(2).split(delimiter);
        }

        String[] result = str.split(",|;");
        return result;
    }

    void checkValidNumber(String str) {
        Matcher matcher = Pattern.compile("^[0-9]+$").matcher(str);

        if (!matcher.find()) {
            throw new RuntimeException("음수 혹은 문자는 계산할 수 없습니다.");
        }
    }
}
