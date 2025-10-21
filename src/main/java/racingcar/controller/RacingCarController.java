package racingcar.controller;

import racingcar.domain.Race;
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
        Race race = setupRacingCars();
        int raceCount = setupRaceCount();
        runRound(race, raceCount);
        printWinners(race);
    }
    private Race setupRacingCars() {
        outputView.printCarNameMessage();
        String[] carNames = inputParser.parseCarNames(inputView.readInput());
        return racingCarService.createCars(carNames);
    }

    private int setupRaceCount() {
        outputView.printTryCountMessage();
        return inputParser.parseRaceCount(inputView.readInput());
    }

    private void runRound(Race race, int raceCount) {
        outputView.printRacingResultMessage();
        for (int i = 0; i < raceCount; i++) {
            racingCarService.runRound(race);
            CarViews carViews = race.getCarViews();
            outputView.printCarMovementCount(carViews);
        }
    }

    private void printWinners(Race race) {
        Winners winners = racingCarService.findWinners(race);
        outputView.printWinnerAnnouncement(winners);
    }
}
