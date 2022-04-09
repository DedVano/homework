package lesson14.homework.classes;

import java.util.Collection;

public class Phonebook {
    private Collection<Contact> contacts;

    public Phonebook(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
