package hu.food.view;

//TODO kirillab ennek is kellene egy service (vagy a web vegye fel a core függőségét és helyezzük át a core-ba)
public enum LocaleEnum {

    HUN("hu"),
    ENG("en");

    public String countryCode;

    LocaleEnum(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
