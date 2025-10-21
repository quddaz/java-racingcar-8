package racingcar.config;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;

    public AppConfig(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

}
