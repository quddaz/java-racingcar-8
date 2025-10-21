package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private static final boolean MOVING_FORWARD = true;
    private static final boolean STOP = false;
    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = new Car("pobi", 0);

        // when
        car.movePosition(MOVING_FORWARD); // 4를 받으면 전진

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_정지_테스트() {
        // given
        Car car = new Car("pobi", 0);

        // when
        car.movePosition(STOP); // 3을 받으면 정지

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
