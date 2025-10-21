package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import racingcar.domain.dto.CarView;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.exception.ErrorMessage;
public class Cars {

    public List<Car> cars;

    public Cars(String[] carName) {
        this.cars = new ArrayList<>();
        addCar(carName);
    }

    public void addCar(String[] carNames) {
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

    public void runSingleRound() {
        for (Car car : cars) {
            car.movePosition();
        }
    }

    public CarViews getCarsView() {
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
