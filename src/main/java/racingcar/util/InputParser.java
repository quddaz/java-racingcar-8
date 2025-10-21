package racingcar.util;

import java.util.Arrays;

public class InputParser {
    private static final String PUBLIC_DELIMITER = ",";

    /**
     * 공백을 제거하고 자동차 이름을 파싱한다.
     * @param input 사용자 입력 문자열
     * @return 자동차 이름 배열
     */
    public String[] parseCarNames(String input) {
        String[] names = input.split(PUBLIC_DELIMITER);
        return Arrays.stream(names)
            .map(String::trim)
            .toArray(String[]::new);
    }

    public int parseRaceCount(String input) {
        return Integer.parseInt(input);
    }
}
