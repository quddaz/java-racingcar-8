package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.CarView;
import racingcar.domain.dto.CarViews;
import racingcar.domain.dto.Winners;
import racingcar.exception.ErrorMessage;
public class Cars {

    private List<Car> cars;

    public Cars(String[] carName) {
        this.cars = new ArrayList<>();
        addCars(carName);
    }

    public void addCars(String[] carNames) {
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
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.movePosition(randomNumber);
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

    public Car getCarByName(String woni) {
        for (Car car : cars) {
            if (car.getName().equals(woni)) {
                return car;
            }
        }
        throw new IllegalArgumentException("해당 이름의 자동차가 없습니다.");
    }
}
