package lesson19.ulil;

import lombok.experimental.UtilityClass;

import java.util.Objects;

@UtilityClass
public class FileUtils {

    public String getFileExtension(String fileName) {
        if (!Objects.isNull(fileName) && !fileName.isEmpty()) {
            int dotIndex = fileName.lastIndexOf(".");
            return (dotIndex != -1 && dotIndex < fileName.length()) ? fileName.substring(dotIndex + 1) : "";
        }
        return null;
    }

    public String getFileNameWithoutExtension(String fileName) {
        if (!Objects.isNull(fileName) && !fileName.isEmpty()) {
            int dotIndex = fileName.lastIndexOf(".");
            return dotIndex != -1 ? fileName.substring(0, dotIndex) : fileName;
        }
        return null;
    }
}
