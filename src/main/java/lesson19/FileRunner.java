package lesson19;

import lesson19.ulil.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class FileRunner {

    public static void main(String[] args) {
        String fileLocation = "D:\\test.txt";
        File file = new File(fileLocation);
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Расширение файла: " + FileUtils.getFileExtension(file.getName()));
        System.out.println("Расширение файла: " + FilenameUtils.getExtension(file.getName()));
        System.out.println("Родительсая папка файла: " + file.getParent());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Существует ли файл? " + (file.exists() ? "Да" : "Нет"));
        System.out.println("Это файл? " + (file.isFile() ? "Да" : "Нет"));
        System.out.println("Создались ли промежуточные папки? " + (file.mkdirs() ? "Да" : "Нет"));
        System.out.println("Всего места на файловой системе: " + file.getTotalSpace() + " байт");
        System.out.println("Свободно из него: " + file.getFreeSpace() + " байт");

    }


}
