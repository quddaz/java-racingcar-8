package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final RacingCarService racingCarService;
    private final RacingCarController racingCarController;

    public AppConfig() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();
        this.racingCarService = new RacingCarService();

        this.racingCarController = new RacingCarController(
            this.racingCarService,
            this.inputView,
            this.outputView,
            this.inputParser
        );
    }

    public RacingCarController getRacingCarController() {
        return racingCarController;
    }
}