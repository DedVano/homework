package lesson14.homework;

import lesson14.homework.classes.*;
import lesson14.homework.enumerations.*;

import java.util.*;
import java.util.stream.IntStream;

public class Runner {


    public static void main(String[] args) {

        int phoneBookCapacity = 10_000;
        int contactProbabilityToBeInAnotherBook = 5;
        System.out.print("Формируем телефонные справочники в различных хранилищах...  ");
        Collection<Long> phonesList = new HashSet<>();
        Collection<Contact> contactsInArrayList = new ArrayList<>();
        Collection<Contact> contactsInLinkedList = new LinkedList<>();
        Collection<Contact> contactsInHashSet = new HashSet<>();
        Collection<Contact> contactsInLinkedHashSet = new LinkedHashSet<>();
        Map<Long, ContactForMap> contactsInHashMap = new HashMap<>();
        ContactForArray[] contactsInArray = new ContactForArray[phoneBookCapacity];
        IntStream.rangeClosed(1, phoneBookCapacity).forEach(iteration -> {
            boolean isMale = new Random().nextBoolean();
            String name = generateName(isMale);
            Phone phone = generateNumber(phonesList);
            phonesList.add(phone.getWholePhoneNumber());
            contactsInArrayList.add(new Contact(name, isMale, phone.getAreaCode().getOriginalOperator(), phone.getAreaCode(),
                    phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new Phonebook(new ArrayList<>())));
            contactsInLinkedList.add(new Contact(name, isMale, phone.getAreaCode().getOriginalOperator(), phone.getAreaCode(),
                    phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new Phonebook(new LinkedList<>())));
            contactsInHashSet.add(new Contact(name, isMale, phone.getAreaCode().getOriginalOperator(), phone.getAreaCode(),
                    phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new Phonebook(new HashSet<>())));
            contactsInLinkedHashSet.add(new Contact(name, isMale, phone.getAreaCode().getOriginalOperator(), phone.getAreaCode(),
                    phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new Phonebook(new LinkedHashSet<>())));
            contactsInHashMap.put(phone.getWholePhoneNumber(), new ContactForMap(name, isMale, phone.getAreaCode().getOriginalOperator(),
                    phone.getAreaCode(), phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new PhonebookForMap(new HashMap<>())));
            contactsInArray[iteration - 1] = new ContactForArray(name, isMale, phone.getAreaCode().getOriginalOperator(), phone.getAreaCode(),
                    phone.getPhoneNumber(), phone.getAreaCode().isUsuallyMobile(), new ContactForArray[0]);
        });
        System.out.println("готово.");
        System.out.println("Заполняем персональные телефонные книги для хранилища ArrayList...");
        generatePrivatePhoneBooks(contactsInArrayList, contactProbabilityToBeInAnotherBook);
        System.out.println("Заполняем персональные телефонные книги для хранилища LinkedList...");
        generatePrivatePhoneBooks(contactsInLinkedList, contactProbabilityToBeInAnotherBook);
        System.out.println("Заполняем персональные телефонные книги для хранилища HashSet...");
        generatePrivatePhoneBooks(contactsInHashSet, contactProbabilityToBeInAnotherBook);
        System.out.println("Заполняем персональные телефонные книги для хранилища LinkedHashSet...");
        generatePrivatePhoneBooks(contactsInLinkedHashSet, contactProbabilityToBeInAnotherBook);
        System.out.println("Заполняем персональные телефонные книги для хранилища HashMap...");
        generatePrivatePhoneBooksForMap(contactsInHashMap, contactProbabilityToBeInAnotherBook);
        System.out.println("Заполняем персональные телефонные книги для хранилища в массиве...");
        generatePrivatePhonebooksForArray(contactsInArray, contactProbabilityToBeInAnotherBook);

        System.out.println("\nПриступаем к нахождению самых популярных членов общества.");
        System.out.println("\nИщем в хранилище ArrayList...");
        findPopularContacts(contactsInArrayList);
        System.out.println("\nИщем в хранилище LinkedList...");
        findPopularContacts(contactsInLinkedList);
        System.out.println("\nИщем в хранилище HashSet...");
        findPopularContacts(contactsInHashSet);
        System.out.println("\nИщем в хранилище LinkedHashSet...");
        findPopularContacts(contactsInLinkedHashSet);
        System.out.println("\nИщем в хранилище HashMap...");
        findPopularContactsInMap(contactsInHashMap);
        System.out.println("\nИщем в массиве...");
        findPopularContactsInArray(contactsInArray);
        System.out.println("\nПоиск завершен, спасибо за внимание и терпение.");
    }


    /**
     * Генерирует случайным образом строку "Фамилия Имя Отчество", принимая во внимания пол, указанный в аргументе.
     * Использует заранее подготовленные списки женских и мужских фамилий, имен и отчеств.
     *
     * @param isMale указатель пола субъекта (true - мужской, false - женский)
     * @return строка Ф.И.О.
     */
    public static String generateName(boolean isMale) {
        String lastName = isMale ?
                String.valueOf(MaleLastNames.values()[(int) (Math.floor(Math.random() * MaleLastNames.values().length))]) :
                String.valueOf(FemaleLastNames.values()[(int) (Math.floor(Math.random() * FemaleLastNames.values().length))]);
        String middleName = isMale ?
                String.valueOf(MaleMiddleNames.values()[(int) (Math.floor(Math.random() * MaleMiddleNames.values().length))]) :
                String.valueOf(FemaleMiddleNames.values()[(int) (Math.floor(Math.random() * FemaleMiddleNames.values().length))]);
        String name = isMale ?
                String.valueOf(MaleNames.values()[(int) (Math.floor(Math.random() * MaleNames.values().length))]) :
                String.valueOf(FemaleNames.values()[(int) (Math.floor(Math.random() * FemaleNames.values().length))]);
        return name + " " + middleName + " " + lastName;
    }

    /**
     * Генерирует случайный номер телефона, не допуская повторений уже имеющихся в списке, передаваемом в качестве аргумента.
     * Использует заранее подготовленные списки кодов оператора и названий операторов.
     *
     * @param phonesList список уже имеющихся телефонных номеров
     * @return объект, содержащий телефонный номер и код оператора
     */
    public static Phone generateNumber(Collection<Long> phonesList) {
        PhoneAreaCodes areaCode;
        int phone;
        long wholePhone;
        do {
            areaCode = (PhoneAreaCodes.values()[(int) (Math.floor(Math.random() * PhoneAreaCodes.values().length))]);
            phone = new Random().nextInt(1000_000, 10_000_000);
            wholePhone = Long.parseLong(String.valueOf(areaCode.getAreaCode()) + phone);
        } while (phonesList.contains(wholePhone));
        return new Phone(areaCode, phone);
    }

    /**
     * Производит заполнение личных телефонных книг каждого контакта из коллекции случайным образом другими контактами
     *
     * @param contacts                            список контактов
     * @param contactProbabilityToBeInAnotherBook вероятность попадания каждого контакта из списка в личную телефонную
     *                                            книгу каждого контакта, 1 шанс из n
     */
    public static void generatePrivatePhoneBooks(Collection<Contact> contacts, int contactProbabilityToBeInAnotherBook) {
        long startTime = System.currentTimeMillis();
        int executionProcess = 0;
        for (Contact processedContact : contacts) {
            for (Contact contact : contacts) {
                if (contact.equals(processedContact)) {
                    continue;
                }
                if (new Random().nextInt(1, contactProbabilityToBeInAnotherBook) == 1) {
                    processedContact.addContactToPhoneBook(contact);
                }
            }
            executionProcess++;
            System.out.printf("\rвыполнено на %.0f%%", (double) executionProcess * 100 / contacts.size());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("\rЗавершено. Затрачено " + estimatedTime / 1000f + " секунд.");
    }

    /**
     * Производит заполнение личных телефонных книг каждого контакта из таблицы соответствий случайным образом другими контактами
     *
     * @param contacts                            список контактов
     * @param contactProbabilityToBeInAnotherBook вероятность попадания каждого контакта из списка в личную телефонную
     *                                            книгу каждого контакта, 1 шанс из n
     */
    public static void generatePrivatePhoneBooksForMap(Map<Long, ContactForMap> contacts, int contactProbabilityToBeInAnotherBook) {
        long startTime = System.currentTimeMillis();
        int executionProcess = 0;
        for (long processedContactKey : contacts.keySet()) {
            for (long contactKey : contacts.keySet()) {
                if (contacts.get(contactKey).equals(contacts.get(processedContactKey))) {
                    continue;
                }
                if (new Random().nextInt(1, contactProbabilityToBeInAnotherBook) == 1) {
                    contacts.get(processedContactKey).addContactToPhoneBook(contacts.get(contactKey));
                }
            }
            executionProcess++;
            System.out.printf("\rвыполнено на %.0f%%", (double) executionProcess * 100 / contacts.size());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("\rЗавершено. Затрачено " + estimatedTime / 1000f + " секунд.");
    }

    /**
     * Производит заполнение личных телефонных книг каждого контакта из массива случайным образом другими контактами
     *
     * @param contacts                            список контактов
     * @param contactProbabilityToBeInAnotherBook вероятность попадания каждого контакта из списка в личную телефонную
     *                                            книгу каждого контакта, 1 шанс из n
     */
    public static void generatePrivatePhonebooksForArray(ContactForArray[] contacts, int contactProbabilityToBeInAnotherBook) {
        long startTime = System.currentTimeMillis();
        int executionProcess = 0;
        for (ContactForArray processedContact : contacts) {
            for (ContactForArray contact : contacts) {
                if (contact.equals(processedContact)) {
                    continue;
                }
                if (new Random().nextInt(1, contactProbabilityToBeInAnotherBook) == 1) {
                    processedContact.addContactToPhoneBook(contact);
                }
            }
            executionProcess++;
            System.out.printf("\rвыполнено на %.0f%%", (double) executionProcess * 100 / contacts.length);
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("\rЗавершено. Затрачено " + estimatedTime / 1000f + " секунд.");
    }

    /**
     * Производит поиск 3-х самых популярных (наиболее часто встречающихся в личных телефонных книгах) контактов в коллекции
     *
     * @param contacts список контактов
     */
    public static void findPopularContacts(Collection<Contact> contacts) {
        long startTime = System.currentTimeMillis();
        int frequentContact1stPlaceCount = 0;
        Contact frequentContact1stPlace = null;
        int frequentContact2ndPlaceCount = 0;
        Contact frequentContact2ndPlace = null;
        int frequentContact3rdPlaceCount = 0;
        Contact frequentContact3rdPlace = null;
        int executionProcess = 0;
        for (Contact lookingContact : contacts) {
            int count = 0;
            for (Contact processedContact : contacts) {
                if (processedContact.getContactsInPhonebook().getContacts().contains(lookingContact)) {
                    count++;
                }
            }
            if (count > frequentContact1stPlaceCount) {
                frequentContact1stPlaceCount = count;
                frequentContact1stPlace = lookingContact;
            } else if (count > frequentContact2ndPlaceCount) {
                frequentContact2ndPlaceCount = count;
                frequentContact2ndPlace = lookingContact;
            } else if (count > frequentContact3rdPlaceCount) {
                frequentContact3rdPlaceCount = count;
                frequentContact3rdPlace = lookingContact;
            }
            executionProcess++;
            System.out.printf("\rпроцесс поиска выполнен на %.0f%%", (double) executionProcess * 100 / contacts.size());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("\rПоиск завершен.\n");
        System.out.println("На первом месте по популярности следующий гражданин (встречается в контактах у " + frequentContact1stPlaceCount + " человек):");
        System.out.println(frequentContact1stPlace);
        System.out.println("На втором месте по популярности следующий гражданин (встречается в контактах у " + frequentContact2ndPlaceCount + " человек):");
        System.out.println(frequentContact2ndPlace);
        System.out.println("На третьем месте по популярности следующий гражданин (встречается в контактах у " + frequentContact3rdPlaceCount + " человек):");
        System.out.println(frequentContact3rdPlace);
        System.out.println("На расчет затрачено " + estimatedTime / 1000f + " секунд.");
    }

    /**
     * Производит поиск 3-х самых популярных (наиболее часто встречающихся в личных телефонных книгах) контактов в таблице соответствий
     *
     * @param contacts список контактов
     */
    public static void findPopularContactsInMap(Map<Long, ContactForMap> contacts) {
        long startTime = System.currentTimeMillis();
        int frequentContact1stPlaceCount = 0;
        ContactForMap frequentContact1stPlace = null;
        int frequentContact2ndPlaceCount = 0;
        ContactForMap frequentContact2ndPlace = null;
        int frequentContact3rdPlaceCount = 0;
        ContactForMap frequentContact3rdPlace = null;
        int executionProcess = 0;
        for (long lookingContactKey : contacts.keySet()) {
            int count = 0;
            for (long processedContactKey : contacts.keySet()) {
                if (contacts.get(processedContactKey).getContactsInPhonebook().getContacts().containsKey(lookingContactKey)) {
                    count++;
                }
            }
            if (count > frequentContact1stPlaceCount) {
                frequentContact1stPlaceCount = count;
                frequentContact1stPlace = contacts.get(lookingContactKey);
            } else if (count > frequentContact2ndPlaceCount) {
                frequentContact2ndPlaceCount = count;
                frequentContact2ndPlace = contacts.get(lookingContactKey);
            } else if (count > frequentContact3rdPlaceCount) {
                frequentContact3rdPlaceCount = count;
                frequentContact3rdPlace = contacts.get(lookingContactKey);
            }
            executionProcess++;
            System.out.printf("\rпроцесс поиска выполнен на %.0f%%", (double) executionProcess * 100 / contacts.size());
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("\rПоиск завершен.\n");
        System.out.println("На первом месте по популярности следующий гражданин (встречается в контактах у " + frequentContact1stPlaceCount + " человек):");
        System.out.println(frequentContact1stPlace);
        System.out.println("На втором месте по популярности следующий гражданин (встречается в контактах у " + frequentContact2ndPlaceCount + " человек):");
        System.out.println(frequentContact2ndPlace);
        System.out.println("На третьем месте по популярности следующий гражданин (встречается в контактах у " + frequentContact3rdPlaceCount + " человек):");
        System.out.println(frequentContact3rdPlace);
        System.out.println("На расчет затрачено " + estimatedTime / 1000f + " секунд.");
    }

    /**
     * Производит поиск 3-х самых популярных (наиболее часто встречающихся в личных телефонных книгах) контактов в массиве
     *
     * @param contacts список контактов
     */
    public static void findPopularContactsInArray(ContactForArray[] contacts) {
        long startTime = System.currentTimeMillis();
        int frequentContact1stPlaceCount = 0;
        ContactForArray frequentContact1stPlace = null;
        int frequentContact2ndPlaceCount = 0;
        ContactForArray frequentContact2ndPlace = null;
        int frequentContact3rdPlaceCount = 0;
        ContactForArray frequentContact3rdPlace = null;
        int executionProcess = 0;
        for (ContactForArray lookingContact : contacts) {
            int count = 0;
            for (ContactForArray processedContact : contacts) {
                for (ContactForArray contact : processedContact.getContactsInPhonebook()) {
                    if (contact != null && contact.equals(lookingContact)) {
                        count++;
                    }
                }
            }
            if (count > frequentContact1stPlaceCount) {
                frequentContact1stPlaceCount = count;
                frequentContact1stPlace = lookingContact;
            } else if (count > frequentContact2ndPlaceCount) {
                frequentContact2ndPlaceCount = count;
                frequentContact2ndPlace = lookingContact;
            } else if (count > frequentContact3rdPlaceCount) {
                frequentContact3rdPlaceCount = count;
                frequentContact3rdPlace = lookingContact;
            }
            executionProcess++;
            System.out.printf("\rпроцесс поиска выполнен на %.0f%%", (double) executionProcess * 100 / contacts.length);
        }
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.print("\rПоиск завершен.\n");
        System.out.println("На первом месте по популярности следующий гражданин (встречается в контактах у " + frequentContact1stPlaceCount + " человек):");
        System.out.println(frequentContact1stPlace);
        System.out.println("На втором месте по популярности следующий гражданин (встречается в контактах у " + frequentContact2ndPlaceCount + " человек):");
        System.out.println(frequentContact2ndPlace);
        System.out.println("На третьем месте по популярности следующий гражданин (встречается в контактах у " + frequentContact3rdPlaceCount + " человек):");
        System.out.println(frequentContact3rdPlace);
        System.out.println("На расчет затрачено " + estimatedTime / 1000f + " секунд.");
    }
}