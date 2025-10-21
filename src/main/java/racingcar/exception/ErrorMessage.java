package racingcar.exception;

public enum ErrorMessage {
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름은 1자 이상 5자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름은 허용되지 않습니다."),
    INVALID_TRY_COUNT("시도 횟수는 1 이상의 숫자여야 합니다."),
    INVALID_CAR_NAME("자동차 이름은 공백이 아니어야 하며, 쉼표(,)를 포함할 수 없습니다.");
    private final String message;
    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
