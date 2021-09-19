package Models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class MyFile {
    private final String fileName;
    private final String absolutePath;
    private final String creationDate;
    private final long size; //в байтах

    public MyFile(File file) throws IOException {
        this.fileName = file.getName();
        this.absolutePath = file.getAbsolutePath();
        this.creationDate = Files.readAttributes(file.toPath(), BasicFileAttributes.class).creationTime().toString().substring(0, 10);
        this.size = file.length();
    }

    public String getFileName() {
        return fileName;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getSize() {
        return String.valueOf(size);
    }
}
