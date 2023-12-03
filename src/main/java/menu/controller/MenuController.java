package menu.controller;

import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        printRecommendationStartMessage();

        printRecommendationEndMessage();
    }

    private void printRecommendationStartMessage() {
        outputView.printRecommendationStartMessage();
    }

    private void printRecommendationEndMessage() {
        outputView.printRecommendationEndMessage();
    }
}
