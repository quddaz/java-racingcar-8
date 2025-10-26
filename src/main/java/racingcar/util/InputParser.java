package racingcar.util;

import racingcar.exception.ErrorMessage;

public class InputParser {
    private static final String PUBLIC_DELIMITER = ",";

    /**
     * 공백을 제거하고 자동차 이름을 파싱한다.
     * @param input 사용자 입력 문자열
     * @return 자동차 이름 배열
     * @throws IllegalArgumentException 유효하지 않은 자동차 이름일 경우
     */
    public String[] parseCarNames(String input) {
        String[] names = input.split(PUBLIC_DELIMITER, - 1);
        for(int i = 0; i < names.length; i++) {
            names[i] = names[i].trim();
            validateCarNames(names[i]);
        }
        validateCarCount(names);
        return names;
    }

    private void validateCarNames(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_EXCEEDED.getMessage());
        }
    }

    private void validateCarCount(String[] names) {
        if (names.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MIN_COUNT_NOT_MET.getMessage());
        }
    }

    /**
     * 시도 횟수를 파싱한다.
     * @param input 사용자 입력 문자열
     * @return 시도 횟수
     * @throws IllegalArgumentException 숫자가 아닌 입력이나 유효하지 않은 시도 횟수일 경우
     */
    public int parseRaceCount(String input) {
        try{
            int raceCount = Integer.parseInt(input);
            validateRaceCount(raceCount);
            return raceCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NON_NUMERIC_TRY_COUNT.getMessage());
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }
}
