package menu;

import menu.controller.MenuController;
import menu.view.console.ConsoleInputView;
import menu.view.console.ConsoleOutputView;

public class Application {
    public static void main(String[] args) {
        new MenuController(
                new ConsoleInputView(),
                new ConsoleOutputView()
        ).run();
    }
}
