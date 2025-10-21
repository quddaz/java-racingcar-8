package racingcar.controller;

import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    public RacingCarController(InputView inputView, OutputView outputView, InputParser inputParser) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void start() {
        // 1. 자동차 이름 입력 요청
        outputView.printCarNameMessage();
        String[] cars = inputParser.parseCarNames(inputView.readInput());

        // 2. 시도 횟수 입력 요청
        outputView.printTryCountMessage();
        int raceCount = inputParser.parseRaceCount(inputView.readInput());

        
    }
}
