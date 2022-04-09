package lesson19.homework;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {

    @SneakyThrows
    public static void main(String[] args) {
        Constructor<?>[] juridicalConstructors = AccountJuridical.class.getConstructors();
        Constructor<?>[] naturalConstructors = AccountNatural.class.getConstructors();
        Constructor<AccountJuridical> juridicalConstructor = (Constructor<AccountJuridical>) getConstructor(juridicalConstructors);
        Constructor<AccountNatural> naturalConstructor = (Constructor<AccountNatural>) getConstructor(naturalConstructors);
        AccountJuridical accountJuridical = juridicalConstructor.newInstance("Зартан", "ООО", new BigDecimal(35_000));
        AccountNatural accountNatural = naturalConstructor.newInstance("Иван Федорович Крузенштерн", 54, true, new BigDecimal(27_000));

        List<Field> allFieldsOfJuridicalAccount = getAllDeclaredFields(AccountJuridical.class);
        List<Field> allFieldsOfNaturalAccount = getAllDeclaredFields(AccountNatural.class);
        System.out.println("Все поля аккаунта юр.лица:");
        viewFields(accountJuridical, allFieldsOfJuridicalAccount);
        System.out.println("\nВсе поля аккаунта физ.лица:");
        viewFields(accountNatural, allFieldsOfNaturalAccount);
    }

    private static Constructor<?> getConstructor(Constructor<?>[] constructors) {
        Constructor<?> resultConstructor = null;
        for (Constructor<?> constructor: constructors) {
            if (constructor.getParameterTypes().length != 0) {
                resultConstructor = constructor;
                break;
            }
        }
        return resultConstructor;
    }

    public static List<Field> getAllDeclaredFields(Class<?> targetClass) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = targetClass; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }

    private static void viewFields(Object account, List<Field> allFieldsOfAccount) throws IllegalAccessException {
        for (Field field : allFieldsOfAccount) {
            field.setAccessible(true);
            System.out.println("Имя поля: " + field.getName());
            System.out.println("Значение поля: " + field.get(account));
        }
    }
}
