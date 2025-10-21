package racingcar.util;

import java.util.List;

public class StubNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;
    private int index = 0;

    public StubNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }
    @Override
    public int generate() {
        return numbers.get(index++);
    }
}