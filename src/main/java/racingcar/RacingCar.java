package racingcar;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCar() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printCarNameMessage();
        String carNamesInput = inputView.readInputCarName();
        int raceCount = inputView.readInputCount();
    }
}
