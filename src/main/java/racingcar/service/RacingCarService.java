package racingcar.service;

import racingcar.domain.Race;
import racingcar.domain.dto.Winners;
import racingcar.util.RandomNumberGenerator;

public class RacingCarService {
    private final RandomNumberGenerator randomNumberGenerator;
    public RacingCarService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }
    public Race createCars(String[] carNames) {
        return new Race(carNames);
    }

    public void runRound(Race race) {
        race.runSingleRound(randomNumberGenerator);
    }

    public Winners findWinners(Race race) {
        return race.getWinners();
    }
}
