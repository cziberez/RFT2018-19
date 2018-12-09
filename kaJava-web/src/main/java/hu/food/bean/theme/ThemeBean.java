package hu.food.bean.theme;

import hu.food.common.Theme;
import hu.food.common.ThemeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ApplicationScoped
@Named("themeBean")
public class ThemeBean implements Serializable {

    private List<Theme> themes;

    @Inject
    private ThemeService themeService;

    @PostConstruct
    public void init() {
        themes = themeService.getThemes();
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setService(ThemeService service) {
        this.themeService = service;
    }
}
