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
        userConsole.printf("Выберите операцию:\n\t1. Упаковать файл в архив\n\t2. Распаковать файл(ы) из архива\nДля выхода наберите 'exit'.\n");
        String packOrUnpackChoice;
        do {
            packOrUnpackChoice = userConsole.getRequestf("Выберите нужный пункт:> ");
            switch (packOrUnpackChoice) {
                case "1" -> {
                    packing(archivator, userConsole);
                    packOrUnpackChoice = "";
                    userConsole.printf("\nВыберите операцию:\n\t1. Упаковать файл в архив\n\t2. Распаковать файл(ы) из архива\nДля выхода наберите 'exit'.\n");
                }
                case "2" -> {
                    unpacking(archivator, userConsole);
                    packOrUnpackChoice = "";
                    userConsole.printf("\nВыберите операцию:\n\t1. Упаковать файл в архив\n\t2. Распаковать файл(ы) из архива\nДля выхода наберите 'exit'.\n");
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
}
