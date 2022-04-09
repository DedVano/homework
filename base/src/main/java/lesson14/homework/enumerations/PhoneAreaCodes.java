package lesson14.homework.enumerations;

public enum PhoneAreaCodes {
    ru7921(7921, PhoneOperators.Мегафон, true),
    ru7929(7929, PhoneOperators.Мегафон, true),
    ru7931(7931, PhoneOperators.Мегафон, true),
    ru7911(7911, PhoneOperators.МТС, true),
    ru7981(7981, PhoneOperators.МТС, true),
    ru7904(7904, PhoneOperators.Теле2, true),
    ru7951(7951, PhoneOperators.Теле2, true),
    ru7952(7952, PhoneOperators.Теле2, true),
    ru7905(7905, PhoneOperators.БиЛайн, true),
    ru7906(7906, PhoneOperators.БиЛайн, true),
    ru7909(7909, PhoneOperators.БиЛайн, true),
    ru7960(7960, PhoneOperators.БиЛайн, true),
    ru7961(7961, PhoneOperators.БиЛайн, true),
    ru7962(7962, PhoneOperators.БиЛайн, true),
    ru7963(7963, PhoneOperators.БиЛайн, true),
    ru7964(7964, PhoneOperators.БиЛайн, true),
    ru7965(7965, PhoneOperators.БиЛайн, true),
    ru7966(7966, PhoneOperators.БиЛайн, true),
    ru7812(7812, PhoneOperators.Ростелеком, false);

    int areaCode;
    PhoneOperators originalOperator;
    boolean usuallyMobile;

    PhoneAreaCodes(int areaCode, PhoneOperators originalOperator, boolean usuallyMobile) {
        this.areaCode = areaCode;
        this.originalOperator = originalOperator;
        this.usuallyMobile = usuallyMobile;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public PhoneOperators getOriginalOperator() {
        return originalOperator;
    }

    public boolean isUsuallyMobile() {
        return usuallyMobile;
    }
}
