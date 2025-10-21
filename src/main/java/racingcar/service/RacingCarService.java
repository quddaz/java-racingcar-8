package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.dto.Winners;

public class RacingCarService {
    public Cars createCars(String[] carNames) {
        return new Cars(carNames);
    }

    public void runRound(Cars cars) {
        cars.runSingleRound();
    }

    public Winners findWinners(Cars cars) {
        return cars.getWinners();
    }
}
