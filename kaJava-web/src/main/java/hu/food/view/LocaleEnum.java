package hu.food.view;

//TODO kirillab ennek is kellene egy service (vagy a web vegye fel a core függőségét és helyezzük át a core-ba)
public enum LocaleEnum {

    HUN("hu"),
    ENG("en");

    public String name;

    LocaleEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
