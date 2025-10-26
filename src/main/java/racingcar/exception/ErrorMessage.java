package racingcar.exception;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    CAR_NAME_MIN_COUNT_NOT_MET("자동차 이름은 최소 2대 이상이어야 합니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름은 허용되지 않습니다."),
    INVALID_TRY_COUNT("시도 횟수는 1 이상의 숫자여야 합니다."),
    NON_NUMERIC_TRY_COUNT("시도 횟수는 숫자여야 합니다.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
