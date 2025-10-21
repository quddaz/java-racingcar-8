package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void movePosition(int number) {
        if (number >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
