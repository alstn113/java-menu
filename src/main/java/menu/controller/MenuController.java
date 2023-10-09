package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.service.MenuService;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.List;
import java.util.Map;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MenuService menuService;

    public MenuController(InputView inputView, OutputView outputView, MenuService menuService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menuService = menuService;
    }

    public void run() {
        outputView.printStartMessage();
        setCoachNames();
        setAvoidMenus();
        menuService.recommendMenu();
        printMenuRecommendation();
        outputView.printEndMessage();
    }

    private void setCoachNames() {
        inputView.retryOnException(() -> {
            String coachNames = inputView.readCoachNames();
            menuService.addCoach(coachNames);
        });
    }

    private void setAvoidMenus() {
        for (Coach coach : menuService.getCoaches()) {
            inputView.retryOnException(() -> {
                String avoidMenus = inputView.readAvoidMenus(coach.getName());
                menuService.addAvoidMenus(coach, avoidMenus);
            });
        }
    }

    private void printMenuRecommendation() {
        Map<Coach, List<String>> coachMenus = menuService.getCoachMenus();
        List<Category> categories = menuService.getCategories();
        outputView.printMenuRecommendation(coachMenus, categories);
    }
}
