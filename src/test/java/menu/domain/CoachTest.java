import menu.domain.Coach;
import menu.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Coach 클래스 테스트")
class CoachTest {

    @Nested
    @DisplayName("이름 관련 테스트")
    class NameTests {

        @Test
        @DisplayName("유효한 이름인 경우")
        void testValidCoachName() {
            String validName = "Ali";
            Coach coach = new Coach(validName);
            assertEquals(validName, coach.getName());
        }

        @Test
        @DisplayName("이름이 너무 짧은 경우 (2글자 미만)")
        void testInvalidCoachNameShort() {
            String invalidName = "A";
            assertThrows(InvalidInputException.class, () -> new Coach(invalidName));
        }

        @Test
        @DisplayName("이름이 너무 긴 경우 (4글자 초과)")
        void testInvalidCoachNameLong() {
            String invalidName = "Alice";
            assertThrows(InvalidInputException.class, () -> new Coach(invalidName));
        }
    }

    @Nested
    @DisplayName("메뉴 제한 관련 테스트")
    class AvoidMenusTests {

        @Test
        @DisplayName("유효한 메뉴 목록인 경우")
        void testValidAvoidMenus() {
            String validInput = "김치찌개,비빔밥";
            Coach coach = new Coach("Ali");
            coach.setAvoidMenus(validInput);

            assertTrue(coach.isAvoidMenu("김치찌개"));
            assertTrue(coach.isAvoidMenu("비빔밥"));
        }

        @Test
        @DisplayName("메뉴가 너무 많은 경우 (2개 초과)")
        void testInvalidAvoidMenusTooMany() {
            String invalidInput = "김치찌개,비빔밥,라면";
            Coach coach = new Coach("Ali");
            assertThrows(InvalidInputException.class, () -> coach.setAvoidMenus(invalidInput));
        }

        @Test
        @DisplayName("중복된 메뉴가 있는 경우")
        void testInvalidAvoidMenusDuplicate() {
            String invalidInput = "김치찌개,김치찌개";
            Coach coach = new Coach("Ali");
            assertThrows(InvalidInputException.class, () -> coach.setAvoidMenus(invalidInput));
        }

        @Test
        @DisplayName("존재하지 않는 메뉴가 있는 경우")
        void testInvalidAvoidMenuNotExist() {
            String invalidInput = "김치찌개,라볶이";
            Coach coach = new Coach("Ali");
            assertThrows(InvalidInputException.class, () -> coach.setAvoidMenus(invalidInput));
        }
    }
}
