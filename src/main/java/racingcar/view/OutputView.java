package racingcar.view;

import racingcar.domain.dto.CarView;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;

public class OutputView {
    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVEMENT_COUNT_MESSAGE = "%s : %s\n";
    private static final String WINNER_ANNOUNCEMENT_MESSAGE = "최종 우승자 : ";

    public void printCarNameMessage() {
        System.out.println(CAR_NAME_INPUT_MESSAGE);
    }

    public void printTryCountMessage() {
        System.out.println(TRY_COUNT_INPUT_MESSAGE);
    }

    public void printRacingResultMessage() {
        System.out.println(RACING_RESULT_MESSAGE);
    }

    public void printCarMovementCount(CarViews carViews) {
        for(CarView carView : carViews.carViews()) {
            System.out.printf(CAR_MOVEMENT_COUNT_MESSAGE,
                carView.name(), "-".repeat(Math.max(0, carView.position())));
        }
        System.out.println();
    }

    public void printWinnerAnnouncement(Winners winners) {
        String winnersJoined = String.join(", ", winners.names());
        System.out.println(WINNER_ANNOUNCEMENT_MESSAGE + winnersJoined);
    }
}
