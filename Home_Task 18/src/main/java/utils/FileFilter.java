package utils;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilter implements FilenameFilter {
    private String ext;

    public FileFilter(String ext) {
        this.ext = ext.toLowerCase();
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(ext);
    }
}
