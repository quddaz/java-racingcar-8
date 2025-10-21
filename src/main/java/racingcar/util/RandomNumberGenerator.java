package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

// 난수 생성 전략 패턴을 위한 인터페이스 구현체
public class RandomNumberGenerator implements NumberGenerator {
    private final int min;
    private final int max;
    public RandomNumberGenerator(int minValue, int maxValue) {
        this.min = minValue;
        this.max = maxValue;
    }
    @Override
    public int generate() {
        return Randoms.pickNumberInRange(min, max);
    }
}
