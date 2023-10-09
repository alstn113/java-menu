package menu.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Category 클래스 테스트")
class CategoryTest {

    @Test
    @DisplayName("존재하는 메뉴인 경우")
    void testIsExistingMenuExists() {
        assertTrue(Category.isExistingMenu("김치찌개"));
        assertTrue(Category.isExistingMenu("스시"));
    }

    @Test
    @DisplayName("존재하지 않는 메뉴인 경우")
    void testIsExistingMenuNotExists() {
        assertFalse(Category.isExistingMenu("라볶이"));
        assertFalse(Category.isExistingMenu("콜라"));
    }

    @Test
    @DisplayName("카테고리 이름 확인")
    void testCategoryName() {
        assertEquals("일식", Category.JAPANESE.getName());
        assertEquals("한식", Category.KOREAN.getName());
        assertEquals("중식", Category.CHINESE.getName());
        assertEquals("아시안", Category.ASIAN.getName());
        assertEquals("양식", Category.WESTERN.getName());
    }

    @Test
    @DisplayName("카테고리 메뉴 목록 확인")
    void testCategoryMenus() {
        assertTrue(Category.JAPANESE.getMenus().contains("규동"));
        assertTrue(Category.KOREAN.getMenus().contains("불고기"));
        assertTrue(Category.CHINESE.getMenus().contains("짜장면"));
        assertTrue(Category.ASIAN.getMenus().contains("나시고렝"));
        assertTrue(Category.WESTERN.getMenus().contains("피자"));
    }
}
