package racingcar.util;

public class InputParser {
    private static final String PUBLIC_DELIMITER = ",";

    public String[] parseCarNames(String input) {
        return input.split(PUBLIC_DELIMITER);
    }

    public int parseRaceCount(String input) {
        return Integer.parseInt(input);
    }
}
