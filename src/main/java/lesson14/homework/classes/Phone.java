package lesson14.homework.classes;

import lesson14.homework.enumerations.PhoneAreaCodes;

public class Phone {
    private final PhoneAreaCodes areaCode;
    private final int phoneNumber;
    private final long wholePhoneNumber;

    public Phone(PhoneAreaCodes areaCode, int phoneNumber) {
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.wholePhoneNumber = areaCode.getAreaCode() * 10_000_000L + phoneNumber;
    }

    public PhoneAreaCodes getAreaCode() {
        return areaCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public long getWholePhoneNumber() {
        return wholePhoneNumber;
    }
}
