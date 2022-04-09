package lesson28.homework;

import lesson28.homework.service.Archivator;
import lesson28.homework.service.UserConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ArchivatorRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext runContext = SpringApplication.run(ArchivatorRunner.class, args);
        Archivator archivator = runContext.getBean(Archivator.class);
        UserConsole userConsole = runContext.getBean(UserConsole.class);
        userConsole.printf("""
                Выберите операцию:
                \t1. Упаковать файл в архив
                \t2. Распаковать файл(ы) из архива
                \t3. Распаковать все файлы из запароленного архива
                Для выхода наберите 'exit'.
                """);
        String packOrUnpackChoice;
        String messageAfterPackOrUnpack = """

                Выберите операцию:
                \t1. Упаковать файл в архив
                \t2. Распаковать файл(ы) из архива
                \t3. Распаковать все файлы из запароленного архива
                Для выхода наберите 'exit'.
                """;
        do {
            packOrUnpackChoice = userConsole.getRequestf("Выберите нужный пункт:> ");
            switch (packOrUnpackChoice) {
                case "1" -> {
                    packing(archivator, userConsole);
                    userConsole.printf(messageAfterPackOrUnpack);
                }
                case "2" -> {
                    unpacking(archivator, userConsole);
                    userConsole.printf(messageAfterPackOrUnpack);
                }
                case "3" -> {
                    unpackingEncrypted(archivator, userConsole);
                    userConsole.printf(messageAfterPackOrUnpack);
                }
                case "exit" -> {
                    userConsole.print("Всего доброго, спасибо, что воспользованись нашим архиватором!");
                    return;
                }
            }
        } while (!(packOrUnpackChoice.equalsIgnoreCase("exit")));
    }

    private static void packing(Archivator archivator, UserConsole userConsole) {
        userConsole.print("Введите имя файла, подлежащего архивации, включая путь:");
        String packedFileName;
        do {
            packedFileName = userConsole.getRequestf(":> ");
        } while (packedFileName.equals(""));
        String archName = userConsole.getRequestf("Введите имя архива.\nДля использования в этом качестве имени файла оставьте строку пустой:\n:> ");
        if (archivator.pack(packedFileName, archName)) {
            userConsole.print("Архивация прошла успешно.");
        } else {
            userConsole.print("Архивация не удалась.");
        }
    }

    private static void unpacking(Archivator archivator, UserConsole userConsole) {
        userConsole.print("Введите имя архива, включая путь:");
        String archName;
        do {
            archName = userConsole.getRequestf(":> ");
        } while (archName.equals(""));
        userConsole.print("Введите имя файла для разархивирования.");
        userConsole.print("Если файл находится во вложенной папке(ах), укажите путь до него, используя '/' как разделитель.");
        userConsole.print("Можно использовать маску '*' в качестве имени файла или расширения.");
        userConsole.print("Для разархивирования всех файлов в архиве оставьте строку пустой.");
        String fileToUnpack = userConsole.getRequestf(":> ");
        if (archivator.unpack(archName, fileToUnpack)) {
            userConsole.print("Разархивация прошла успешно.");
        } else {
            userConsole.print("Разархивация не удалась.");
        }
    }

    private static void unpackingEncrypted(Archivator archivator, UserConsole userConsole) {
        userConsole.print("Введите имя архива, включая путь:");
        String archName;
        do {
            archName = userConsole.getRequestf(":> ");
        } while (archName.equals(""));
        userConsole.print("Введите пароль архива");
        String password = userConsole.getRequestf(":> ");
        if (archivator.unpackEncrypted(archName, password)) {
            userConsole.print("Разархивация прошла успешно.");
        } else {
            userConsole.print("Разархивация не удалась.");
        }
    }
}
