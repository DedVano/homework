package lesson14.homework.classes;

import lesson14.homework.enumerations.PhoneAreaCodes;
import lesson14.homework.enumerations.PhoneOperators;

import java.util.Objects;

public class Contact {
    private final String name;
    private final boolean isMale;
    private PhoneOperators operator;
    private PhoneAreaCodes areaCode;
    private int phoneNumber;
    private long wholePhoneNumber;
    private boolean isMobile;
    private Phonebook contactsInPhonebook;

    public Contact(String name, boolean isMale, PhoneOperators operator, PhoneAreaCodes areaCode, int phoneNumber, boolean isMobile,
                   Phonebook contactsInPhonebook) {
        this.name = name;
        this.isMale = isMale;
        this.operator = operator;
        this.areaCode = areaCode;
        this.phoneNumber = phoneNumber;
        this.isMobile = isMobile;
        this.contactsInPhonebook = contactsInPhonebook;
        this.wholePhoneNumber = areaCode.getAreaCode() * 10_000_000L + phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return wholePhoneNumber == contact.wholePhoneNumber && Objects.equals(name, contact.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, wholePhoneNumber);
    }

    @Override
    public String toString() {
        return "Карточка контакта {" +
                "Ф.И.О.: '" + name + '\'' +
                ", оператор: " + operator +
                ", телефон: +" + wholePhoneNumber +
                ", " + (isMobile ? "мобильный номер" : "городской номер") +
                '}';
    }

    public String getName() {
        return name;
    }

    public PhoneOperators getOperator() {
        return operator;
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

    public boolean isMobile() {
        return isMobile;
    }

    public Phonebook getContactsInPhonebook() {
        return contactsInPhonebook;
    }

    public void addContactToPhoneBook(Contact contact) {
        contactsInPhonebook.addContact(contact);
    }
}
