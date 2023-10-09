package menu.domain;

import java.util.HashSet;
import java.util.Set;

public class Coach {
    private String name;
    private Set<String> avoidMenus;

    public Coach(String name) {
        this.name = name;
        this.avoidMenus = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getAvoidMenus() {
        return avoidMenus;
    }
}
