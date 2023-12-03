package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuRecommendation;
import menu.domain.parser.CannotEatMenusParser;
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
        setCannotEatMenusForCoaches(coaches);
        MenuRecommendation menuRecommendation = new MenuRecommendation(coaches);
        printRecommendationResult(menuRecommendation);
        printRecommendationEndMessage();
    }

    private Coaches createCoaches() {
        return InputUtil.retryOnException(() -> {
            String coachNames = inputView.readCoachNames();
            return CoachesParser.parseToCoaches(coachNames);
        });
    }

    private void setCannotEatMenusForCoaches(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            List<String> cannotEatMenus = readCannotEatMenusForCoach(coach);
            coach.setCannotEatMenus(cannotEatMenus);
        }
    }

    private List<String> readCannotEatMenusForCoach(Coach coach) {
        return InputUtil.retryOnException(() -> {
            String cannotEatMenus = inputView.readCannotEatMenusForCoach(coach.getName());
            return CannotEatMenusParser.parseToCannotEatMenus(cannotEatMenus);
        });
    }

    private void printRecommendationStartMessage() {
        outputView.printRecommendationStartMessage();
    }

    private void printRecommendationResult(MenuRecommendation menuRecommendation) {
        outputView.printRecommendationResult(menuRecommendation.getRecommendationCategories(),
                menuRecommendation.getCoachRecommendationMenus());
    }

    private void printRecommendationEndMessage() {
        outputView.printRecommendationEndMessage();
    }
}
