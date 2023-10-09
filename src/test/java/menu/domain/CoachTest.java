package menu.domain;

import menu.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Coach 클래스")
public class CoachTest {

    @Nested
    @DisplayName("생성자")
    class ConstructorTests {
        @Test
        @DisplayName("유효한 이름으로 Coach 객체를 생성할 수 있어야 함")
        void validName() {
            // Arrange
            String validName = "pobi";

            // Act
            Coach coach = new Coach(validName);

            // Assert
            assertEquals(validName, coach.getName());
        }

        @Test
        @DisplayName("이름이 2자리보다 짧을 경우 InvalidInputException 발생")
        void nameTooShort() {
            // Arrange
            String invalidName = "A";

            // Act & Assert
            assertThrows(InvalidInputException.class, () -> new Coach(invalidName));
        }

        @Test
        @DisplayName("이름이 4자리보다 길 경우 InvalidInputException 발생")
        void nameTooLong() {
            // Arrange
            String invalidName = "Alexandra";

            // Act & Assert
            assertThrows(InvalidInputException.class, () -> new Coach(invalidName));
        }
    }

    @Nested
    @DisplayName("setAvoidMenus 메서드")
    class SetAvoidMenusTests {
        @Test
        @DisplayName("유효한 메뉴 입력으로 Set이 업데이트되어야 함")
        void validInput() {
            Coach coach = new Coach("Bob");
            String validInput = "Sushi,Ramen";

            coach.setAvoidMenus(validInput);
            Set<String> avoidMenus = coach.getAvoidMenus();

            assertTrue(avoidMenus.contains("Sushi"));
            assertTrue(avoidMenus.contains("Ramen"));
        }

        @Test
        @DisplayName("못 먹는 메뉴가 없을 경우 에러가 발생하지 않음")
        void emptyInput() {
            // Arrange
            Coach coach = new Coach("pobi");
            String emptyInput = "";

            // Act & Assert
            assertDoesNotThrow(() -> coach.setAvoidMenus(emptyInput));
        }

        @Test
        @DisplayName("메뉴가 2개보다 많을 경우 InvalidInputException 발생")
        void tooManyMenus() {
            // Arrange
            Coach coach = new Coach("pobi");
            String invalidInput = "Burger,Pizza,Sandwich";

            // Act & Assert
            assertThrows(InvalidInputException.class, () -> coach.setAvoidMenus(invalidInput));
        }

        @Test
        @DisplayName("중복된 메뉴가 있으면 InvalidInputException 발생")
        void duplicateMenus() {
            // Arrange
            Coach coach = new Coach("Cali");
            String invalidInput = "Pasta,Pizza,Pasta";

            // Act & Assert
            assertThrows(InvalidInputException.class, () -> coach.setAvoidMenus(invalidInput));
        }
    }
}
