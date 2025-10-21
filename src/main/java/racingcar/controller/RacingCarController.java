package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingCarService;

public class RacingCarController {
    private final RacingCarService racingCarService;
    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void start() {
        Cars cars = racingCarService.setupRacingCars();
        int raceCount = racingCarService.setupRaceCount();
        racingCarService.startRacing(cars, raceCount);
        racingCarService.printWinners(cars);
    }
}
