package menu.service;

import menu.domain.Coach;
import menu.exception.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("MenuService 클래스 테스트")
class MenuServiceTest {

    private MenuService menuService;

    @BeforeEach
    void setUp() {
        menuService = new MenuService();
    }

    @Test
    @DisplayName("코치 추가")
    void testAddCoach() {
        menuService.addCoach("구구,토미,제임스");

        List<Coach> coaches = menuService.getCoaches();
        assertEquals(3, coaches.size());
        assertEquals("구구", coaches.get(0).getName());
        assertEquals("토미", coaches.get(1).getName());
        assertEquals("제임스", coaches.get(2).getName());
    }

    @Test
    @DisplayName("코치 이름 길이 유효성 검사 - 성공")
    void testAddCoachValidLength() {
        menuService.addCoach("구구,토미,제임스");

        List<Coach> coaches = menuService.getCoaches();
        assertEquals(3, coaches.size());
    }

    @Test
    @DisplayName("코치 이름 길이 유효성 검사 - 실패")
    void testAddCoachInvalidLength() {
        assertThrows(InvalidInputException.class, () -> {
            menuService.addCoach("이이, 삼삼삼, 사사사사, 오오오오오");
        });
    }

    @Test
    @DisplayName("못 먹는 메뉴 입력 - 존재하지 않는 메뉴")
    void testAddAvoidMenusInvalidInput() {
        assertThrows(InvalidInputException.class, () -> {
            menuService.addAvoidMenus(new Coach("구구"), "두부,콜라,라면");
        });
    }

    @Test
    @DisplayName("못 먹는 메뉴 입력 - 길이 실패")
    void testAddAvoidMenusInvalidLength() {
        assertThrows(InvalidInputException.class, () -> {
            menuService.addAvoidMenus(new Coach("구구"), "스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        });
    }

    @Test
    @DisplayName("메뉴 추천 - 카테고리 개수")
    void testRecommendMenuCategoryCount() {
        menuService.addCoach("구구,토미,제임스");
        menuService.recommendMenu();

        assertEquals(5, menuService.getCategories().size());
    }

    @Test
    @DisplayName("메뉴 추천 - 코치별 메뉴 개수")
    void testRecommendMenuCoachMenuCount() {
        menuService.addCoach("구구,토미,제임스");
        menuService.recommendMenu();

        assertEquals(5, menuService.getCoachMenus().get(menuService.getCoaches().get(0)).size());
        assertEquals(5, menuService.getCoachMenus().get(menuService.getCoaches().get(1)).size());
        assertEquals(5, menuService.getCoachMenus().get(menuService.getCoaches().get(2)).size());

        assertEquals(3, menuService.getCoaches().size());
    }

    @Test
    @DisplayName("메뉴 추천 - 코치별 메뉴 중복 없음")
    void testRecommendMenuCoachMenuDuplicate() {
        menuService.addCoach("구구,토미,제임스");
        menuService.recommendMenu();

        List<String> menus1 = menuService.getCoachMenus().get(menuService.getCoaches().get(0));
        List<String> menus2 = menuService.getCoachMenus().get(menuService.getCoaches().get(1));
        List<String> menus3 = menuService.getCoachMenus().get(menuService.getCoaches().get(2));

        assertEquals(5, menus1.stream().distinct().count());
        assertEquals(5, menus2.stream().distinct().count());
        assertEquals(5, menus3.stream().distinct().count());
    }

    @Test
    @DisplayName("메뉴 추천 - 한 주의 카테고리 3개일 수 밖에 없음")
    void testRecommendMenuCategoryNotOverTwo() {
        menuService.addCoach("구구,토미,제임스");
        menuService.recommendMenu();

        assertThat(menuService.getCategories().stream().distinct().count()).isGreaterThan(2);
    }


}
