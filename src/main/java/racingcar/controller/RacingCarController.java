package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView, InputParser inputParser) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void start() {
        Cars cars = setupRacingCars();
        int raceCount = setupRaceCount();
        runRound(cars, raceCount);
        printWinners(cars);
    }
    private Cars setupRacingCars() {
        outputView.printCarNameMessage();
        String[] carNames = inputParser.parseCarNames(inputView.readInput());
        return racingCarService.createCars(carNames);
    }

    private int setupRaceCount() {
        outputView.printTryCountMessage();
        return inputParser.parseRaceCount(inputView.readInput());
    }

    private void runRound(Cars cars, int raceCount) {
        outputView.printRacingResultMessage();
        for (int i = 0; i < raceCount; i++) {
            racingCarService.runRound(cars);
            CarViews carViews = cars.getCarViews();
            outputView.printCarMovementCount(carViews);
        }
    }

    private void printWinners(Cars cars) {
        Winners winners = racingCarService.findWinners(cars);
        outputView.printWinnerAnnouncement(winners);
    }
}
