package racingcar.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {
    private final InputParser inputParser = new InputParser();
    @Test
    void 공백_이름_테스트(){
        // given
        String input = "pobi, ,woni";
        // when & then
        assertThatThrownBy(() -> inputParser.parseCarNames(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 빈 칸일 수 없습니다.");
    }

    @Test
    void 이름_길이_초과_테스트() {
        // given
        String input = "pobi,javajiiii,woni";
        // when & then
        assertThatThrownBy(() -> inputParser.parseCarNames(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 1자 이상 5자 이하이어야 합니다.");
    }

    @Test
    void 시도_횟수_예외_테스트() {
        // given
        String input = "0";
        // when & then
        assertThatThrownBy(() -> inputParser.parseRaceCount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 시도_횟수_숫자_아님_테스트() {
        // given
        String input = "abc";
        // when & then
        assertThatThrownBy(() -> inputParser.parseRaceCount(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("시도 횟수는 숫자여야 합니다.");
    }

}
