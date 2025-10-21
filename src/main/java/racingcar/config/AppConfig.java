package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final RacingCarController racingCarController;

    public AppConfig(){
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();
        this.racingCarController = new RacingCarController(inputView, outputView, inputParser);
    }

    public RacingCarController getRacingCarController(){
        return racingCarController;
    }
}
