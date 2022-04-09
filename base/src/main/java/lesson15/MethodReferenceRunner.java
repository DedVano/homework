package lesson15;

import lesson15.dto.Account;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceRunner {

    public static void main(String[] args) {
        Function<String, Integer> str2IntOld = str -> Integer.decode(str);
        Function<String, Integer> str2Int = Integer::decode;
        Consumer<String> printStr = System.out::println;
        Supplier<Account> accountGenerator = Account::new;
        Supplier<Account> accountGenerator2 = () -> new Account();

        Function<Long, Long> self2Self = val -> val;
        Function<Long, Long> self2Self2 = Function.identity();

        System.out.println(str2Int.apply("1"));
        Function<Character, Integer> char2Int = ch -> (int) ch;
        System.out.println(char2Int.apply(' '));

    }
}
