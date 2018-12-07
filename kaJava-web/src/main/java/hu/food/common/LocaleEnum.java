package hu.food.common;

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
