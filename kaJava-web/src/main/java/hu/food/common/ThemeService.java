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
        themes.add(new Theme(3, "Sam", "sam"));
        themes.add(new Theme(4, "Black-Tie", "black-tie"));
        themes.add(new Theme(5, "Humanity", "humanity"));
        themes.add(new Theme(6, "Home", "home"));
        themes.add(new Theme(7, "Sunny", "sunny"));
        themes.add(new Theme(8, "Blitzer", "blitzer"));
        themes.add(new Theme(9, "Bootstrap", "bootstrap"));
        themes.add(new Theme(10, "Cupertino", "cupertino"));
        themes.add(new Theme(11, "Dark-Hive", "dark-hive"));
        themes.add(new Theme(12, "Delta", "delta"));
        themes.add(new Theme(13, "Excite-Bike", "excite-bike"));
        themes.add(new Theme(14, "Le-Frog", "le-frog"));
        themes.add(new Theme(15, "Flick", "flick"));
        themes.add(new Theme(16, "Midnight", "midnight"));
        themes.add(new Theme(17, "Trontastic", "trontastic"));
        themes.add(new Theme(18, "UI-Darkness", "ui-darkness"));
        themes.add(new Theme(19, "UI-Lightness", "ui-lightness"));
    }

    public List<Theme> getThemes() {
        return themes;
    }
}
