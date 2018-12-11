package hu.food.common;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//TODO kirillab átmozgatni a service-be
@Named("themeService")
@ApplicationScoped
public class ThemeService implements Serializable {

    private List<Theme> themes;

    @PostConstruct
    public void init() {
        themes = new ArrayList<>();
        themes.add(new Theme(0, "Start", "start"));
        themes.add(new Theme(1, "South-Street", "south-street"));
        themes.add(new Theme(2, "Redmond", "redmond"));
        themes.add(new Theme(3, "Humanity", "humanity"));
        themes.add(new Theme(4, "Home", "home"));
        themes.add(new Theme(5, "Sunny", "sunny"));
        themes.add(new Theme(6, "Blitzer", "blitzer"));
        themes.add(new Theme(7, "Bootstrap", "bootstrap"));
        themes.add(new Theme(8, "Cupertino", "cupertino"));
        themes.add(new Theme(9, "Dark-Hive", "dark-hive"));
        themes.add(new Theme(10, "Delta", "delta"));
        themes.add(new Theme(11, "Excite-Bike", "excite-bike"));
        themes.add(new Theme(12, "Flick", "flick"));
        themes.add(new Theme(13, "Midnight", "midnight"));
        themes.add(new Theme(14, "Trontastic", "trontastic"));
        themes.add(new Theme(15, "Black-Tie", "black-tie"));
        themes.add(new Theme(16, "UI-Darkness", "ui-darkness"));
        themes.add(new Theme(17, "UI-Lightness", "ui-lightness"));
    }

    public List<Theme> getThemes() {
        return themes;
    }
}
