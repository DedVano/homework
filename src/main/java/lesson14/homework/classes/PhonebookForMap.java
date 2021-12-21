package lesson14.homework.classes;

import java.util.Map;

public class PhonebookForMap {
    private Map<Long, ContactForMap> contacts;

    public PhonebookForMap(Map<Long, ContactForMap> contacts) {
        this.contacts = contacts;
    }

    public Map<Long, ContactForMap> getContacts() {
        return contacts;
    }

    public void addContact(ContactForMap contact) {
        this.contacts.put(contact.getWholePhoneNumber(), contact);
    }
}
