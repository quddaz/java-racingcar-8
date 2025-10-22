package racingcar.config;

import racingcar.controller.RacingCarController;
import racingcar.service.RacingCarService;
import racingcar.util.InputParser;
import racingcar.util.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;
    private final RandomNumberGenerator randomNumberGenerator;
    private final RacingCarService racingCarService;
    private final RacingCarController racingCarController;

    private final int RANDOM_MIN_VALUE = 0;
    private final int RANDOM_MAX_VALUE = 9;

    public AppConfig() {
        // View & Util
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputParser = new InputParser();

        // Service & Controller
        this.randomNumberGenerator = new RandomNumberGenerator(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
        this.racingCarService = new RacingCarService(randomNumberGenerator);

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
