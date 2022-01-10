package lesson18;

import lesson18.dto.Person;
import lesson18.dto.Sex;
import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationRunner {
@SneakyThrows
    public static void main(String[] args) {
        Person ivanovVitaliy = new Person("Ivanov Vitaliy", 33, Sex.MALE, 190);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\person.dat"))) {
            oos.writeObject(ivanovVitaliy);
        }
    }
}
