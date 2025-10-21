package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readInputCarName() {
        return Console.readLine();
    }
    public int readInputCount() {
        return Integer.parseInt(Console.readLine());
    }
}
