package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.dto.CarView;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.exception.ErrorMessage;
import racingcar.util.NumberGenerator;

public class Race {

    private List<Car> cars;

    public Race(String[] carName) {
        this.cars = new ArrayList<>();
        setupRaceCarNameList(carName);
    }

    public void setupRaceCarNameList(String[] carNames) {
        for (String name : carNames) {
            // 기존 cars 리스트에 하나라도 있는지 확인합니다.
            boolean isDuplicate = cars.stream()
                .anyMatch(car -> car.getName().equals(name));

            if (isDuplicate) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
            }
            cars.add(new Car(name, 0));
        }
    }

    /**
     * 한 라운드 동안 모든 자동차의 위치를 업데이트합니다.
     * @param numberGenerator 랜덤 숫자 생성기(테스트 용이성을 위해 주입)
     */
    public void runSingleRound(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            int randomNumber = numberGenerator.generate();
            car.movePosition(randomNumber >= 4);
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
