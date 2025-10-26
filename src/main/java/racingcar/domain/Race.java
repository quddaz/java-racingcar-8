package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import racingcar.domain.dto.CarView;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.exception.ErrorMessage;
import racingcar.util.NumberGenerator;

public class Race {

    private final List<Car> cars;
    private static final int MOVING_FORWARD = 4;
    public Race(String[] carNames) {
        validateDuplicates(carNames);
        this.cars = Arrays.stream(carNames)
            .map(name -> new Car(name, 0))
            .collect(Collectors.toList());
    }

    private void validateDuplicates(String[] carNames){
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(carNames));
        if(uniqueNames.size() != carNames.length) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    /**
     * 한 라운드 동안 모든 자동차의 위치를 업데이트합니다.
     * @param numberGenerator 랜덤 숫자 생성기(테스트 용이성을 위해 주입)
     */
    public void runSingleRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generate();
            if(randomNumber >= MOVING_FORWARD)
                car.move();
        }
    }

    public CarViews getCarViews() {
        return new CarViews(cars.stream()
            .map(car -> new CarView(car.getName(), car.getPosition()))
            .toList());
    }

    public Winners getWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(0);

            return new Winners(cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList());
    }

}
