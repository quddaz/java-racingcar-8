package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void movePosition() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        position += randomNumber >= 4 ? 1 : 0 ;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
