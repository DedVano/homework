package lesson28.homework.service.impl;

import lesson28.homework.service.Archivator;
import lesson28.homework.service.UserConsole;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

@Service
@RequiredArgsConstructor
public class ArchivatorImpl implements Archivator {

    private static final int BUFFER_SIZE = 8192;
    private final UserConsole userConsole;

    @Override
    public boolean pack(String fileNameWithPath, String archName) {
        if (!Files.exists(Path.of(fileNameWithPath))) {
            userConsole.print("Файл " + fileNameWithPath + " не найден.");
            return false;
        }
        if (archName.equals("")) {
            archName = FilenameUtils.getBaseName(fileNameWithPath) + ".zip";
            userConsole.print("Имя архивного файла не указано, используем " + archName);
        } else if (FilenameUtils.getExtension(archName).equals("")) {
            archName += ".zip";
            userConsole.print("Расширение архивного файла не указано, используем .zip");
        }
        if (FilenameUtils.getFullPath(archName).equals("")) {
            archName = FilenameUtils.getFullPath(fileNameWithPath) + archName;
            userConsole.print("Путь к архивному файлу не указан, используем " + archName);
        }
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archName));
             FileInputStream fileInputStream = new FileInputStream(fileNameWithPath)) {
            zipOutputStream.putNextEntry(new ZipEntry(FilenameUtils.getName(fileNameWithPath)));
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            zipOutputStream.write(buffer);
        } catch (FileNotFoundException fnfe) {
            userConsole.printf("Файл не найден.");
            userConsole.print(fnfe.getMessage());
            return false;
        } catch (IOException ioe) {
            userConsole.printf("Произошла ошибка ввода-вывода.");
            userConsole.print(ioe.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean unpack(String archNameWithPath, String fileName) {
        if (!Files.exists(Path.of(archNameWithPath))) {
            userConsole.print("Файл " + archNameWithPath + " не найден.");
            return false;
        }
        String pathToUnpack = FilenameUtils.getFullPath(archNameWithPath) + FilenameUtils.getBaseName(archNameWithPath) + "\\";
        boolean filesFoundInArch = false;
        int unpackedFilesCount = 0;
        long startTime = System.currentTimeMillis();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archNameWithPath))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                String entryName = zipEntry.getName();
                boolean pathEquals = FilenameUtils.getFullPath(fileName).equalsIgnoreCase(FilenameUtils.getFullPath(entryName));
                boolean baseNameEquals = FilenameUtils.getBaseName(fileName).equalsIgnoreCase(FilenameUtils.getBaseName(entryName));
                boolean extensionEquals = FilenameUtils.getExtension(fileName).equalsIgnoreCase(FilenameUtils.getExtension(entryName));
                if (fileName.equals("")
                        || entryName.equalsIgnoreCase(fileName)
                        || (pathEquals && FilenameUtils.getName(fileName).equals("*"))
                        || (pathEquals && extensionEquals && FilenameUtils.getBaseName(fileName).equals("*"))
                        || (pathEquals && baseNameEquals && FilenameUtils.getExtension(fileName).equals("*"))) {
                    userConsole.printf("Распаковывается файл: %s \t Размер: %d байт \n", entryName, zipEntry.getSize());
                    Path entryPath = Path.of(pathToUnpack + FilenameUtils.getFullPath(entryName));
                    if (!Files.exists(entryPath)) {
                        Files.createDirectories(entryPath);
                    }
                    if (writeUnpackedFile(pathToUnpack + entryName, zipInputStream)) {
                        filesFoundInArch = true;
                        unpackedFilesCount++;
                    }
                    zipInputStream.closeEntry();
                }
            }
        } catch (FileNotFoundException fnfe) {
            userConsole.print("Файл не найден.");
            userConsole.print(fnfe.getMessage());
            return false;
        } catch (IOException ioe) {
            userConsole.print("Произошла ошибка ввода-вывода.");
            userConsole.print(ioe.getMessage());
            return false;
        }
        if (!filesFoundInArch) {
            userConsole.print("Заданный файл в архиве не обнаружен.");
            return false;
        }
        userConsole.print("Распаковано файлов: " + unpackedFilesCount);
        userConsole.print("Затрачено времени: " + (System.currentTimeMillis() - startTime) + " миллисекунд.");
        return true;
    }

    private boolean writeUnpackedFile(String newFileName, ZipInputStream zipInputStream) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(newFileName)) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesCount;
            while ((bytesCount = zipInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, bytesCount);
            }
            fileOutputStream.flush();
        } catch (FileNotFoundException e) {
            userConsole.print("Не удалось создать файл.");
            return false;
        } catch (IOException e) {
            userConsole.print("Произошла ошибка ввода-вывода.");
            return false;
        }
        return true;
    }
}

