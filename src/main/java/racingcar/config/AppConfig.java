package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {
    private final RacingCarController racingCarController;

    public AppConfig(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputParser inputParser = new InputParser();
        RacingCarService racingCarService = new RacingCarService(inputView, outputView, inputParser);
        this.racingCarController = new RacingCarController(racingCarService);
    }

    public RacingCarController getRacingCarController(){
        return racingCarController;
    }
}
