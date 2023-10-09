package menu.view;

public class InputView {
    private final OutputView outputView;

    public InputView() {
        this.outputView = new OutputView();
    }

    public String read(String query) {
        outputView.print(query);
        return System.console().readLine();
    }
}
