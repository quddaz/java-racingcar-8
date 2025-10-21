package racingcar.domain;


import org.junit.jupiter.api.Test;
import racingcar.domain.dto.Winners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarsTest {
    @Test
    void 중복된_이름이_있으면_예외가_발생한다() {
        // given
        String[] names = {"pobi", "pobi", "woni"};

        // when & then
        assertThatThrownBy(() -> new Cars(names))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 자동차 이름은 허용되지 않습니다.");
    }
    @Test
    void 단독_우승자_선정_테스트() {
        // given
        Cars cars = new Cars(new String[]{"pobi", "woni", "jun"});
        // 위치 설정
        cars.getCarByName("pobi").movePosition(5); // pobi 위치 1
        cars.getCarByName("woni").movePosition(3); // woni 위치 0
        cars.getCarByName("jun").movePosition(4);  // jun 위치 1

        // when
        Winners winners = cars.getWinners();
        // then
        assertThat(winners.names()).containsExactly("pobi", "jun");
    }

    @Test
    void 공동_우승자_선정_테스트() {
        // given
        Cars cars = new Cars(new String[]{"pobi", "woni", "jun"});
        // 위치 설정
        cars.getCarByName("pobi").movePosition(5); // pobi 위치 1
        cars.getCarByName("woni").movePosition(4); // woni 위치 1
        cars.getCarByName("jun").movePosition(3);  // jun 위치 0

        // when
        Winners winners = cars.getWinners();
        // then
        assertThat(winners.names()).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    void 모두가_우승자일_경우_테스트() {
        // given
        Cars cars = new Cars(new String[]{"pobi", "woni", "jun"});
        // 위치는 기본값 0

        // when
        Winners winners = cars.getWinners();

        // then
        assertThat(winners.names()).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
