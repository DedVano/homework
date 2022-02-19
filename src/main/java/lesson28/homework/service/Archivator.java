package lesson28.homework.service;

public interface Archivator {
    boolean pack(String fileNameWithPath, String ArchName);
    boolean unpack(String archNameWithPath, String fileName);
}
