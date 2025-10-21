package racingcar;

import racingcar.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        appConfig.getRacingCarController().start();
    }
}
