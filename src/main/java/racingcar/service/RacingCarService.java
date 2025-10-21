package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarService {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    public RacingCarService(InputView inputView, OutputView outputView, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public Cars setupRacingCars() {
        // 1. 자동차 이름 입력 요청
        outputView.printCarNameMessage();
        String[] cars = inputParser.parseCarNames(inputView.readInput());
        return new Cars(cars);
    }

    public int setupRaceCount() {
        // 2. 시도 횟수 입력 요청
        outputView.printTryCountMessage();
        return inputParser.parseRaceCount(inputView.readInput());
    }

    public void startRacing(Cars racingCars, int raceCount) {
        // 3. 레이싱 실행
        outputView.printRacingResultMessage();
        for (int i = 0; i < raceCount; i++) {
            racingCars.runSingleRound();
            outputView.printCarMovementCount(racingCars.getCarsView());
        }
    }

    public void printWinners(Cars racingCars) {
        // 4. 우승자 발표
        Winners winners = racingCars.getWinners();
        outputView.printWinnerAnnouncement(winners);
    }

}
