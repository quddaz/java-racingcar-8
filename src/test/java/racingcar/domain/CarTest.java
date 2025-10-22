package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    @Test
    void 자동차_전진_테스트() {
        // given
        Car car = new Car("pobi", 0);

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
