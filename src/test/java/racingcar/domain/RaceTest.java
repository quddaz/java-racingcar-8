package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.dto.Winners;
import racingcar.util.NumberGenerator;
import racingcar.util.StubNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class RaceTest {
    @Test
    void 중복된_이름_예외_테스트() {
        // given
        String[] names = {"pobi", "pobi", "woni"};

        // when & then
        assertThatThrownBy(() -> new Race(names))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 단독_우승자_선정_테스트() {
        // given
        // 시나리오: pobi(전진), woni(정지), jun(정지)
        NumberGenerator generator = new StubNumberGenerator(List.of(4, 3, 0));
        Race race = new Race(new String[]{"pobi", "woni", "jun"});

        // when
        race.runSingleRound(generator);
        Winners winners = race.getWinners();

        // then
        assertThat(winners.names()).containsExactly("pobi");
    }

    @Test
    void 공동_우승자_선정_테스트() {
        // given
        // 시나리오: pobi(전진), woni(정지), jun(전진)
        NumberGenerator generator = new StubNumberGenerator(List.of(5, 2, 9));
        Race race = new Race(new String[]{"pobi", "woni", "jun"});

        // when
        race.runSingleRound(generator);
        Winners winners = race.getWinners();

        // then
        assertThat(winners.names()).containsExactlyInAnyOrder("pobi", "jun");
    }

    @Test
    void 모두가_우승자일_경우_테스트() {
        // given
        // 시나리오: 모두 정지
        NumberGenerator generator = new StubNumberGenerator(List.of(0, 1, 2));
        Race race = new Race(new String[]{"pobi", "woni", "jun"});

        // when
        race.runSingleRound(generator); // 실행해도 모두 위치는 0
        Winners winners = race.getWinners();

        // then
        assertThat(winners.names()).containsExactlyInAnyOrder("pobi", "woni", "jun");
    }
}
