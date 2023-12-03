package menu.controller;

import menu.domain.Coaches;
import menu.domain.parser.CoachesParser;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.util.InputUtil;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        printRecommendationStartMessage();
        Coaches coaches = createCoaches();
        printRecommendationEndMessage();
    }

    private Coaches createCoaches() {
        return InputUtil.retryOnException(() -> {
            String coachNames = inputView.readCoachNames();
            return CoachesParser.parseToCoaches(coachNames);
        });
    }

    private void printRecommendationStartMessage() {
        outputView.printRecommendationStartMessage();
    }

    private void printRecommendationEndMessage() {
        outputView.printRecommendationEndMessage();
    }
}
