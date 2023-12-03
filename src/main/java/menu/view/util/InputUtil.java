package menu.view.util;

import java.util.function.Supplier;
import menu.exception.ErrorMessage;
import menu.exception.InvalidInputException;

public class InputUtil {
    private InputUtil() {
    }

    public static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static <T> T retryOnException(Supplier<T> supplier, boolean lineBreak) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                if (lineBreak) {
                    System.out.println();
                }
            }
        }
    }

    public static <T> T retryOnException(Supplier<T> supplier) {
        return retryOnException(supplier, false);
    }
}
